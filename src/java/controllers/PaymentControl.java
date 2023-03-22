/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.Cart;
import database.CartFacade;
import database.Item;
import database.OrderListFacade;
import database.PaymentFacade;
import database.Product;
import database.ProductFacade;
import database.User;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "PaymentControl", urlPatterns = {"/payment"})
public class PaymentControl extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int TEMP_PROD_EXPIRY = 24 * 60 * 60;
    CartFacade cf = new CartFacade();
    ProductFacade pf = new ProductFacade();
    User user = new User();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");

        switch (action) {
            case "checkout":
                HttpSession session = request.getSession();
                Cart cart = (Cart) session.getAttribute("cart");
                session.setAttribute("cart", cart);
                request.setAttribute("count", cart.getCount());
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "checkout_handler":
                checkout_handler(request, response);
                break;
            case "cart":
                cart(request, response);
                break;

            case "delete":
                delete(request, response);
                break;
            case "empty":
                empty(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "success":
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            default:
                request.setAttribute("message", "Page not found");
                request.setAttribute("controller", "error");
                request.setAttribute("action", "error");
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
        }
    }

    protected Cart getCart(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cart cart = new Cart();
        String list = "";
        for (Cookie cook : cookies) {
            if (cook.getName().equals("cart")) {
                list = cook.getValue();
            }
        }
        if (!list.isEmpty()) {
            String[] listOfProduct = list.split(",");
            for (String word : listOfProduct) {
                String[] p = word.split("-");
                ProductFacade pf = new ProductFacade();
                try {
                    Product product = pf.read(p[0]);
                    int quantity = Integer.parseInt(p[1]);
                    cart.update(product, quantity);
                } catch (Exception e) {
                    System.out.println("Can't get the product with Id: " + p[0]);
                }
            }
        }
        return cart;
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        Cart cart = getCart(request);
        user = (User) session.getAttribute("user");
        Product product = pf.read(productId);
        cart.remove(product);
        if (user != null) {
            int userId = user.getUserId();
            cf.delete(userId, productId);
        } else {
            Cookie cookCart = new Cookie("cart", cart.toString());
            cookCart.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookCart);
        }
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void empty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        user = (User) session.getAttribute("user");
        if (user != null) {
            int userId = user.getUserId();
            cf.empty(userId);
        } else {
            Cookie cookCart = new Cookie("cart", null);
            cookCart.setMaxAge(0);
            response.addCookie(cookCart);
        }
        session.setAttribute("cart", null);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        int quantity = Integer.parseInt(request.getParameter("addQuantity"));
        Cart cart = getCart(request);
        user = (User) session.getAttribute("user");
        Product product = pf.read(productId);
        cart.update(product, quantity);
        if (user != null) {
            int userId = user.getUserId();
            cf.update(userId, productId, quantity);
        } else {
            Cookie cookCart = new Cookie("cart", cart.toString());
            cookCart.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookCart);
        }
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void cart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        double total = 0;
        Cart cart = new Cart();
        if (user != null) {
            int userId = user.getUserId();
            cart = cart = cf.select(userId);
        } else {
            cart = getCart(request);
        }
        total = cart.getTotal();
        request.setAttribute("count", cart.getCount());
        request.setAttribute("total", total);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void checkout_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String action = request.getParameter("action");
        switch (action) {
            case "purchase":
                String fullName = request.getParameter("fullName");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String zip = request.getParameter("zip");
                String cardname = request.getParameter("cardname");
                String cardnumber = request.getParameter("cardnumber");
                int expmonth = Integer.parseInt(request.getParameter("expmonth"));
                int expyear = Integer.parseInt(request.getParameter("expyear"));
                String cvv = request.getParameter("cvv");
                int index = 0;
                PaymentFacade pf = new PaymentFacade();
                boolean checkPaymentCard = pf.checkPaymentCard(cardname, cardnumber, expmonth, expyear, cvv);
                if (checkPaymentCard = false) {
                    request.setAttribute("message", "Invalid Payment Info, please check again.");
                } else {
                    HttpSession session = request.getSession();
                    user = (User) session.getAttribute("user");
                    int userId = user.getUserId();
                    Cart cart = getCart(request);
                    cart = cf.select(userId);
                    OrderListFacade olf = new OrderListFacade();
                    ProductFacade prf = new ProductFacade();
                    Date issueDate = new Date();
                    for (Item item : cart.getItem()) {
                        olf.add(item, user.getUserId(), issueDate);
                        Product product = item.getProduct();
                        int quantity = 100-item.getQuantity();
                        System.out.println(quantity);
                        product.setQuantity(quantity);
                        prf.update(product);
                    }
                    response.sendRedirect(request.getContextPath() + "/payment/success.page");
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/home/index.page");
                break;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
