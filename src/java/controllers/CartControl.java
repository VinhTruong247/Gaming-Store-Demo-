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
 * @author VU HONG ANH
 */
@WebServlet(name = "CartControl", urlPatterns = {"/cart"})
public class CartControl extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int TEMP_PROD_EXPIRY = 24 * 60 * 60;
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
        String op = request.getParameter("op");
        switch (op) {
            case "add":
                add(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "empty":
                empty(request, response);
                break;
            case "checkout":
                checkout(request, response);
                break;
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String productId = request.getParameter("productId");
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String username = "";
        if (user != null) {
            username = user.getFullName();
            cf.add(username, productId);
        } else {
            Cookie[] cookies = request.getCookies();
            String list = "";
            for (Cookie cook : cookies) {
                if (cook.getName().equals("cart")) {
                    list = cook.getValue();
                }
            }
            if (list.isEmpty()) {
                list = productId;
            } else {
                list += "," + productId;
            }
            Cookie cookProd = new Cookie("cart", list);
            cookProd.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookProd);
        }
        System.out.println(username);

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
            System.out.println(listOfProduct);
            for(String p : listOfProduct){
                System.out.println(p);
            }
        }
        System.out.println("ddd");
        Cart cart = (Cart) session.getAttribute("cart");
        cart.remove(productId);
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void empty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        String username = "";
        if (user != null) {
            username = user.getFullName();
        } else {
            username = "unknown";
        }
        Cart cart = (Cart) session.getAttribute("cart");
        cart.empty();
        cf.empty(username);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void checkout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

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
            Logger.getLogger(CartControl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CartControl.class.getName()).log(Level.SEVERE, null, ex);
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
