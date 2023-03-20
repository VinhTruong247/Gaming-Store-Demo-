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
import utils.Hasher;
import utils.Tools;

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
            case "signup":
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "signup_handler":
                signup_handler(request, response);
                break;
            case "profile":
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "edit":
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "edit_handler":
                edit_handler(request, response);
                break;
            case "changePass":
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "changePass_handler":
                changePass_handler(request, response);
                break;
        }
    }

    protected void login_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");
        switch (op) {
            case "login":
                try {
                    String loginInput = request.getParameter("loginInput").trim();
                    String password = request.getParameter("password");
                    UserFacade uf = new UserFacade();
                    if (uf.checkAccountExist(loginInput) != 0) {
                        User user = new User();
                        if (password.length() < 20) {
                            password = Hasher.hash(password);
                        }
                        user = uf.login(loginInput, password);
                        if (user == null) {
                            request.setAttribute("message", "Incorrect username/email or password.");
                            request.getRequestDispatcher("/user/login.page").forward(request, response);
                        } else {
                            String remember = request.getParameter("remember");
                            if (remember != null) {
                                Cookie cookUser = new Cookie("cookUser", user.getUsername());
                                Cookie cookPass = new Cookie("cookPass", password);
                                Cookie cookRemember = new Cookie("cookRemember", remember);
                                cookUser.setMaxAge(REMEMBER_ME_EXPIRY);
                                cookPass.setMaxAge(REMEMBER_ME_EXPIRY);
                                cookRemember.setMaxAge(REMEMBER_ME_EXPIRY);
                                response.addCookie(cookUser);
                                response.addCookie(cookPass);
                                response.addCookie(cookRemember);
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
                    request.setAttribute("message", "Unable to update info due to: " + ex.getMessage());
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
        Cookie cookUser = new Cookie("cookUser", null);
        Cookie cookPass = new Cookie("cookPass", null);
        Cookie cookRemember = new Cookie("cookRemember", null);
        cookUser.setMaxAge(0);
        cookPass.setMaxAge(0);
        cookRemember.setMaxAge(0);
        response.addCookie(cookUser);
        response.addCookie(cookPass);
        response.addCookie(cookRemember);
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/home/index.page");
    }

    protected void signup_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "signup":
                String fullName = request.getParameter("fullName").trim();
                String username = request.getParameter("username").trim();
                String email = request.getParameter("email").trim();
                String address = request.getParameter("address").trim();
                HttpSession session = request.getSession();
                UserFacade uf = new UserFacade();
                request.setAttribute("fullName", fullName);
                try {
                    if (uf.checkAccountExist(username) == 0 && uf.checkAccountExist(email) == 0) {
                        request.setAttribute("username", username);
                        request.setAttribute("email", email);
                        request.setAttribute("address", address);
                        String role = request.getParameter("role");
                        int id = uf.getNextId(role);
                        String password = request.getParameter("password");
                        String confirmPass = request.getParameter("confirmPass");
                        if (Tools.verifyPassword(password)) {
                            if (password.equals(confirmPass)) {
                                User user = new User(role, id, username, email, Hasher.hash(password), fullName, address);
                                uf.create(user);
                                session.setAttribute("user", user);
                                request.setAttribute("announce", "Signup done, you can go back to Home Page now.");
                                response.sendRedirect(request.getContextPath() + "/home/index.page");
                            } else {
                                request.setAttribute("message", "Unable to signup due to: Confirm password doesn't match.");
                                request.getRequestDispatcher("/user/signup.page").forward(request, response);
                            }
                        } else {
                            request.setAttribute("message", "Unable to signup due to: password doesn't meet requirement (Only alphanumeric, Ex: 1234,abcd,...)");
                            request.getRequestDispatcher("/user/signup.page").forward(request, response);
                        }
                    } else {
                        request.setAttribute("message", "Unable to signup due to: Username or email already existed.");
                        request.getRequestDispatcher("/user/signup.page").forward(request, response);
                    }
                } catch (Exception ex) {
                    String message = "Unable to signup due to: ";
                    if (ex.toString().contains("duplicate")) {
                        message += "Account already exists.";
                    } else {
                        message += "Unable to create account.";
                    }
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/user/signup.page").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/user/login.page");
                break;
        }
    }

    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "apply":
                HttpSession session = request.getSession();
                User oldUser = (User) session.getAttribute("user");
                try {
                    UserFacade uf = new UserFacade();
                    User newUser = new User();
                    String username = request.getParameter("username");
                    String email = request.getParameter("email");
                    if (username.isEmpty()) {
                        username = oldUser.getUsername();

                    } else {
                        Cookie cookUser = new Cookie("cookUser", username);
                        cookUser.setMaxAge(REMEMBER_ME_EXPIRY);
                        response.addCookie(cookUser);
                    }
                    if (email.isEmpty()) {
                        email = oldUser.getEmail();
                    }
                    String role = request.getParameter("role");
                    int id = Integer.parseInt(request.getParameter("id"));
                    String fullName = request.getParameter("fullName");
                    if (fullName.isEmpty()) {
                        fullName = oldUser.getFullName();
                    }
                    String address = request.getParameter("address");
                    String password = request.getParameter("pasword");
                    newUser = new User(role, id, username, email, password, fullName, address);
                    uf.update(newUser);
                    session.setAttribute("user", newUser);
                    response.sendRedirect(request.getContextPath() + "/user/profile.page");
                } catch (Exception ex) {
                    session.setAttribute("user", oldUser);
                    String message = "Unable to edit due to: ";
                    if (ex.toString().contains("duplicate")) {
                        message += "Account already exists";
                    } else {
                        message += "Unable to edit account";
                    }
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/user/edit.page").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/user/profile.page");
                break;
        }
    }

    protected void changePass_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "apply":
                try {
                    String oldPass = request.getParameter("oldPass");
                    System.out.println(oldPass);
                    HttpSession session = request.getSession();
                    User user = (User) session.getAttribute("user");
                    System.out.println(oldPass);
                    System.out.println(user.getPassword());
                    System.out.println(Hasher.hash(oldPass));
                    if (!(user.getPassword()).equals(Hasher.hash(oldPass))) {
                        System.out.println(oldPass);
                        request.setAttribute("message", "Incorrect old password.");
                        request.getRequestDispatcher("/user/changePass.page").forward(request, response);
                    } else {
                        String newPass = request.getParameter("newPass");
                        if (Tools.verifyPassword(newPass)) {
                            user.setPassword(Hasher.hash(newPass));
                            UserFacade uf = new UserFacade();
                            uf.changePass(user);
                            Cookie cookPass = new Cookie("cookPass", user.getPassword());
                            cookPass.setMaxAge(REMEMBER_ME_EXPIRY);
                            response.addCookie(cookPass);
                            session.setAttribute("user", user);
                            response.sendRedirect(request.getContextPath() + "/user/profile.page");
                        } else {
                            request.setAttribute("message", "Unable to change password due to: new password doesn't meet requirement (Only alphanumeric, Ex: 1234,abcd,...)");
                            request.getRequestDispatcher("/user/changePass.page").forward(request, response);
                        }
                    }
                } catch (Exception ex) {
                    request.setAttribute("message", "Unable to change password due to: " + ex.toString());
                    request.getRequestDispatcher("/user/changePass.page").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/user/profile.page");
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
