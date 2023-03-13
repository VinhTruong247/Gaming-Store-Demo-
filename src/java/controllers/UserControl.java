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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author binla
 */
@WebServlet(name = "UserControl", urlPatterns = {"/user"})
public class UserControl extends HttpServlet {

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
            case "login":
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "login_handler":
                login_handler(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "userlist":
                userlist(request, response);
                break;
            case "signup":
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "signup_handler":
                signup_handler(request, response);
                break;
        }
    }

    protected void login_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");
        switch (op) {
            case "login":
                try {
                    String loginInput = request.getParameter("loginInput");
                    String password = request.getParameter("password");
                    UserFacade uf = new UserFacade();
                    if (uf.checkAccountExist(loginInput)) {
                        User user = new User();
                        user = uf.login(loginInput, password);
                        if (user == null) {
                            request.setAttribute("message", "Incorrect username/email or password.");
                            request.getRequestDispatcher("/user/login.page").forward(request, response);
                        } else {
                            String remember = request.getParameter("remember");
                            System.out.println(remember);
                            if (remember != null) {
                                Cookie cookuser = new Cookie("cookuser", user.getUsername());
                                Cookie cookpass = new Cookie("cookpass", password);
                                Cookie cookremember = new Cookie("cookremember", remember);
                                cookuser.setMaxAge(REMEMBER_ME_EXPIRY);
                                cookpass.setMaxAge(REMEMBER_ME_EXPIRY);
                                cookremember.setMaxAge(REMEMBER_ME_EXPIRY);
                                response.addCookie(cookuser);
                                response.addCookie(cookpass);
                                response.addCookie(cookremember);
                            }
                            HttpSession session = request.getSession();
                            session.setAttribute("user", user);
                            response.sendRedirect(request.getContextPath() + "/home/index.page");
                        }
                    } else {
                        request.setAttribute("message", "Account doesn't exist. Create new Account?");
                        request.getRequestDispatcher("/user/login.page").forward(request, response);
                    }
                } catch (Exception ex) {
                    request.setAttribute("message", ex.toString());
                    request.getRequestDispatcher("/user/login.page").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/home/index.page");
                break;
        }

    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookuser = new Cookie("cookuser", null);
        Cookie cookpass = new Cookie("cookpass", null);
        Cookie cookremember = new Cookie("cookremember", null);
        cookuser.setMaxAge(0);
        cookpass.setMaxAge(0);
        cookremember.setMaxAge(0);
        response.addCookie(cookuser);
        response.addCookie(cookpass);
        response.addCookie(cookremember);
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/home/index.page");
    }

    protected void userlist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserFacade uf = new UserFacade();
            List<User> list = uf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }
    }

    protected void signup_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "signup":
                try {
                    UserFacade uf = new UserFacade();
                    String role = request.getParameter("role");
                    int id = uf.getNextId(role);
                    String fullName = request.getParameter("fullName");
                    String username = request.getParameter("username");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    User user = new User(role, uf.getNextId(role), username, email, password, fullName);
                    uf.create(user);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                } catch (Exception ex) {
                    request.setAttribute("message", ex.toString());
                    request.getRequestDispatcher("/user/signup.page").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/user/login.page");
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
