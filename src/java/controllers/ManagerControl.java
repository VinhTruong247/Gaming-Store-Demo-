/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.User;
import database.UserFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Hasher;
import utils.Tools;

/**
 *
 * @author binla
 */
@WebServlet(name = "ManagerControl", urlPatterns = {"/manager"})
public class ManagerControl extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int REMEMBER_ME_EXPIRY = 90 * 24 * 60 * 60;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "promote":
                promote(request, response);
                break;
            case "deactivate":
                deactivate(request, response);
                break;
            case "promote_handler":
                promote_handler(request, response);
                break;
            case "deactivate_handler":
                deactivate_handler(request, response);
                break;
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserFacade uf = new UserFacade();
            String searchPhrase = request.getParameter("searchPhrase");
            List<User> list = new ArrayList();
            if(searchPhrase==null) list = uf.select();
            else list = uf.search(searchPhrase);
            request.setAttribute("list", list);
            request.setAttribute("isTrue", true);
        } catch (Exception e) {
            request.setAttribute("isTrue", false);
            request.setAttribute("message", "Can't get User database.");
        }
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void promote(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserFacade uf = new UserFacade();
            String username = request.getParameter("username");
            User selectedUser = uf.getUser(username);
            if (selectedUser.getRole().equals("ADMIN")) {
                request.setAttribute("isTrue", false);
                request.setAttribute("message", "Can't promote because: This user is already an ADMIN.");
            } else if (!selectedUser.isActive()) {
                request.setAttribute("isTrue", false);
                request.setAttribute("message", "Can't promote because: This user has been deactived.");
            } else {
                request.setAttribute("isTrue", true);
                request.setAttribute("selectedUser", selectedUser);
            }
        } catch (Exception e) {
            request.setAttribute("isTrue", false);
            request.setAttribute("message", "Can't get User.");
        }
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void deactivate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserFacade uf = new UserFacade();
            String username = request.getParameter("username");
            User selectedUser = uf.getUser(username);
            if (selectedUser.getRole().equals("ADMIN")) {
                request.setAttribute("isTrue", false);
                request.setAttribute("message", "Can't deactivate because: This user is an ADMIN.");
            } else if (!selectedUser.isActive()) {
                request.setAttribute("isTrue", false);
                request.setAttribute("message", "Can't promote because: This user has already been deactived.");
            } else {
                request.setAttribute("isTrue", true);
                request.setAttribute("selectedUser", selectedUser);
            }
        } catch (Exception e) {
            request.setAttribute("isTrue", false);
            request.setAttribute("message", "Can't get User.");
        }
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void promote_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "promote":
                try {
                    int userId = Integer.parseInt(request.getParameter("userId"));
                    System.out.println(userId);
                    UserFacade uf = new UserFacade();
                    int count = uf.promote(userId);
                    response.sendRedirect(request.getContextPath() + "/manager/index.page");
                } catch (Exception e) {
                    request.setAttribute("isTrue", false);
                    request.setAttribute("message", "Can't promote this User.");
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/manager/index.page");
                break;
        }
    }

    protected void deactivate_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "deactivate":
                try {
                    int userId = Integer.parseInt(request.getParameter("userId"));
                    UserFacade uf = new UserFacade();
                    int count = uf.deactivate(userId);
                    response.sendRedirect(request.getContextPath() + "/manager/index.page");
                } catch (Exception e) {
                    request.setAttribute("isTrue", false);
                    request.setAttribute("message", "Can't deactivate this User.");
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/manager/index.page");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
