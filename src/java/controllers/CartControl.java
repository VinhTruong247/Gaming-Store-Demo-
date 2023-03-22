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
        String op = request.getParameter("op");
        switch (op) {
            case "add":
                add(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "empty":
                empty(request, response);
                break;
        }
    }
    protected Cart getCart(HttpServletRequest request){
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
                try{
                Product product = pf.read(p[0]);
                int quantity = Integer.parseInt(p[1]);
                cart.update(product, quantity);
                } catch(Exception e){
                    System.out.println("Can't get the product with Id: "+p[0]);
                }
            }
        }
        return cart;
    }
    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        int quantity = Integer.parseInt(request.getParameter("addQuantity"));
        user = (User) session.getAttribute("user");
        Product newProduct = pf.read(productId);
        Cart cart = getCart(request);
        cart.add(newProduct, quantity);
        if (user != null) {
            int userId = user.getUserId();
            if (cf.checkExist(userId, productId)) {
                cf.update(userId, productId, cart.getQuantity(productId));
            } else {
                cf.add(userId, productId, quantity);
            }
        } else {
            Cookie cookCart = new Cookie("cart", cart.toString());
            cookCart.setMaxAge(TEMP_PROD_EXPIRY);
            response.addCookie(cookCart);
        }
        session.setAttribute("cart", cart);
        request.setAttribute("productId", productId);
        request.setAttribute("addQuantity", quantity);
        request.getRequestDispatcher("/product/single_product.page").forward(request, response);
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
        response.sendRedirect(request.getHeader("referer"));
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
        response.sendRedirect(request.getHeader("referer"));
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
