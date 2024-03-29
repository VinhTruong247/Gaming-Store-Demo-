/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.OrderListFacade;
import database.Product;
import database.ProductFacade;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.ceil;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VU HONG ANH
 */
@WebServlet(name = "ProductControl", urlPatterns = {"/product"})
public class ProductControl extends HttpServlet {

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
            case "manager":
                manager(request, response);
                break;
            case "sale":
                try {
                    sale(request, response);
                } catch (Exception e) {
                    System.out.println(e);
                }
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "create_handler":
                create_handler(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "update_handler":
                update_handler(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "delete_handler":
                delete_handler(request, response);
                break;
            case "page":
                page(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "single_product":
                single_product(request, response);
                break;
            default:
                request.setAttribute("message", "Page not found");
                request.setAttribute("controller", "error");
                request.setAttribute("action", "error");
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
        }
    }

    protected void sale(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        ProductFacade pf = new ProductFacade();
        OrderListFacade olf = new OrderListFacade();
        List<String> id = olf.select();
        System.out.println("Still work");
        for (String productId : id) {
            Product product = pf.read(productId);
            if(!pf.checkExist(productId)) pf.saleCreate(product);
            System.out.println("Still work");
        }
        System.out.println("done");
        List<Product> list = pf.saleSelect();
        for(Product p : list){
            System.out.println(p.getProductName());
        }
        request.setAttribute("list", list);
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String searchPhrase = request.getParameter("searchPhrase");
        String option = request.getParameter("option");
        try {
            ProductFacade pf = new ProductFacade();
            List<Product> list = pf.searchProduct(searchPhrase, option);
            request.setAttribute("searchList", list);
            request.setAttribute("searchPhrase", searchPhrase);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void page(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        try {

            ProductFacade pf = new ProductFacade();
            int count = pf.countProduct();
            int totalPage = count / 6;
            System.out.println(totalPage);
            if (count % 3 != 0) {
                totalPage++;
            }

            List<Product> list = pf.selectPerPage(currentPage);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("list", list);
            request.setAttribute("totalPage", totalPage);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void manager(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("ADMIN")) {
            try {
                ProductFacade pf = new ProductFacade();
                List<Product> list = pf.select();
                request.setAttribute("list", list);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("message", e.getMessage());
                request.setAttribute("controller", "error");
                request.setAttribute("action", "error");
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/product/manager.page");
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("ADMIN")) {
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/product/manager.page");
        }
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
                    String productId = request.getParameter("productId");
                    String productName = request.getParameter("productName");
                    String productPublisher = request.getParameter("productPublisher");
                    String category = request.getParameter("category");
                    String description = request.getParameter("description");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    String productImages = request.getParameter("productImages");
                    Product product = new Product(productId, productName, productPublisher, category, description, quantity, price, productImages);
                    request.setAttribute("product", product);
                    ProductFacade pf = new ProductFacade();
                    pf.create(product);
                    response.sendRedirect(request.getContextPath() + "/product/manager.page");
                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/product/manager.page");
                break;
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("ADMIN")) {
            try {
                String productId = request.getParameter("productId");
                ProductFacade pf = new ProductFacade();
                Product product = pf.read(productId);
                if (product == null) {
                    System.out.println("error");
                }
                request.setAttribute("product", product);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("message", e.getMessage());
                request.setAttribute("controller", "error");
                request.setAttribute("action", "error");
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/product/manager.page");
        }
    }

    protected void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    String productId = request.getParameter("productId");
                    String productName = request.getParameter("productName");
                    String productPublisher = request.getParameter("productPublisher");
                    String category = request.getParameter("category");
                    String description = request.getParameter("description");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    String productImages = request.getParameter("productImages");
                    Product product = new Product(productId, productName, productPublisher, category, description, quantity, price, productImages);
                    request.setAttribute("product", product);

                    ProductFacade pf = new ProductFacade();
                    pf.update(product);
                    response.sendRedirect(request.getContextPath() + "/product/manager.page");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex);
                    request.setAttribute("action", "update");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/product/manager.page");
                break;
            default:
                break;
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("ADMIN")) {
            String productId = request.getParameter("productId");
            request.setAttribute("productId", productId);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/product/manager.page");
        }
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "yes":
                String productId = request.getParameter("productId");
                ProductFacade pf = new ProductFacade();
                try {
                    pf.delete(productId);
                    response.sendRedirect(request.getContextPath() + "/product/manager.page");
                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
            case "no":
                response.sendRedirect(request.getContextPath() + "/product/manager.page");
                break;
        }
    }

    protected void single_product(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String productId = request.getParameter("productId");
            ProductFacade pf = new ProductFacade();
            Product product = pf.read(productId);
            if (product == null) {
                System.out.println("error");
            }
            String op = request.getParameter("op");
            session.setAttribute("prodcut", product);
            request.setAttribute("product", product);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
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
