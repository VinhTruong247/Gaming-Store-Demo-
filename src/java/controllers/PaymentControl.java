/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.Cart;
import database.CartFacade;
import database.Item;
import database.PaymentFacade;
import database.Product;
import database.ProductFacade;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "checkout_handler":
                checkout_handler(request, response);
                break;
            case "cart":
                cart(request, response);
                break;
            case "add":
                add(request, response);
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

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        user = (User) session.getAttribute("user");
        if (user != null) {
            int userId = user.getUserId();
            Product product = pf.read(productId);
            cf.add(userId, productId, quantity);
        } else {
            Cookie[] cookies = request.getCookies();
            String list = "";
            for (Cookie cook : cookies) {
                if (cook.getName().equals("cart")) {
                    list = cook.getValue();
                }
            }
            String nextProduct = productId + "-" + quantity;
            if (list.isEmpty()) {
                list = nextProduct;
            } else {
                list += "," + nextProduct;
            }
            Cookie cookCart = new Cookie("cart", list);
            cookCart.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookCart);
        }
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        user = (User) session.getAttribute("user");
        if (user != null) {
            int userId = user.getUserId();
            Product product = pf.read(productId);
            cf.delete(userId, productId);
        } else {
            Cookie[] cookies = request.getCookies();
            String list = "";
            for (Cookie cook : cookies) {
                if (cook.getName().equals("cart")) {
                    list = cook.getValue();
                }
            }
            String p = productId + "-" + quantity;
            list.replaceAll(p, "");
            list.replaceAll(",,", ",");
            Cookie cookCart = new Cookie("cart", list);
            cookCart.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookCart);
        }
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void empty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        user = (User) session.getAttribute("user");
        if (user != null) {
            int userId = user.getUserId();
            cf.delete(userId, productId);
        } else {
            Cookie cookCart = new Cookie("cart", "");
            cookCart.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookCart);
        }
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
        user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        if (user != null) {
            cf.update(userId, productId, newQuantity);
        } else {
            Cookie[] cookies = request.getCookies();
            String list = "";
            for (Cookie cook : cookies) {
                if (cook.getName().equals("cart")) {
                    list = cook.getValue();
                }
            }
            String[] listOfProduct = list.split(",");
            int oldQuantity = 0;
            for (String word : listOfProduct) {
                String[] p = word.split("-");
                if (p[0].equals(productId)) {
                    oldQuantity = Integer.parseInt(p[1]);
                }
            }
            String oldProduct = productId + "-" + oldQuantity;
            String newProduct = productId + "-" + newQuantity;
            list.replaceAll(oldProduct, newProduct);
            Cookie cookCart = new Cookie("cart", list);
            cookCart.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookCart);
        }
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void cart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        user = (User) session.getAttribute("user");
        double total = 0;
        Cart cart = new Cart();
        if (user != null) {
            int userId = user.getUserId();
            cart = cart = cf.select(userId);
        } else {
            Cookie[] cookies = request.getCookies();
            String list = "";
            for (Cookie cook : cookies) {
                if (cook.getName().equals("cart")) {
                    list = cook.getValue();
                }
            }
            String[] listOfProduct = list.split(",");
            for (String word : listOfProduct) {
                String[] p = word.split("-");
                Product product = pf.read(p[0]);
                int quantity = Integer.parseInt(p[1]);
                cart.update(product, quantity);
            }
        }
        total = cart.getTotal();
        request.setAttribute("total", total);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void checkout_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
            String action = request.getParameter("action");
            switch (action) {
                case "success":
                    HttpSession session = request.getSession();
                    Cart cart = (Cart) session.getAttribute("cart");

                    response.sendRedirect(request.getContextPath() + "/payment/checkout.page");
                    break;
                case "cancel":
                    response.sendRedirect(request.getContextPath() + "/home/index.page");
                    break;
            }
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
