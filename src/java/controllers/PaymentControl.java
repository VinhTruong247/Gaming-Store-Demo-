/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.Cart;
import database.CartFacade;
import database.Item;
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

    CartFacade cf = new CartFacade();
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

        String productId = request.getParameter("productId");
        ProductFacade pf = new ProductFacade();
        Product product = pf.read(productId);
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String username = "";
        if (user != null) {
            username = user.getFullName();
        } else {
            username = "unknown";
        }
        Item item = new Item(product, username);
        List<Product> products = pf.select();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(item);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String productId = request.getParameter("productId");
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String username = "";
        if (user != null) {
            username = user.getFullName();
            cf.delete(username, productId);
        } else {
            Cookie[] cookies = request.getCookies();
            String list = "";
            for (Cookie cook : cookies) {
                if (cook.getName().equals("cart")) {
                    list = cook.getValue();
                }
            }
            String[] listOfProduct = list.split(productId);
            for(String p : listOfProduct){
                System.out.println(p);
            }
        }
        Cart cart = (Cart) session.getAttribute("cart");
        cart.remove(productId);
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void empty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.empty();
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String productId = request.getParameter("productId");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void cart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String username = "";
        Cart cart = new Cart();
        double total = 0;
        if (user != null) {
            username = user.getFullName();
            List<Product> list = cf.select(username);
            for (Product p : list) {
                Item item = new Item(p, username);
                cart.add(item);
            }
        } else {
            ProductFacade pf = new ProductFacade();
            Cookie[] cookies = request.getCookies();
            String list = "";
            for (Cookie cook : cookies) {
                if (cook.getName().equals("cart")) {
                    list = cook.getValue();
                }
            }
            String[] listOfProduct = list.split(",");
            for (String p : listOfProduct) {
                Item item = new Item(pf.read(p), username);
                cart.add(item);
            }
        }
        total = cart.getTotal();
        request.setAttribute("total", total);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void checkout_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
