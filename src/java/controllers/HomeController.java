/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.BrandFacade;
import db.CategoryFacade;
import db.OrderFacade;
import db.ProductFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;
import models.Brand;
import models.Category;
import models.Order;
import models.Product;
import utils.Config;

/**
 *
 * @author PHT
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

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

        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "index":
                //Processing code here
                getList(request, response);
                //Forward request & response to the main layout
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "aboutus":
                //Processing code here
                //Forward request & response to the main layout
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "product":
                //Processing code here
                products(request, response);
                //Forward request & response to the main layout
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "cart":
                //Processing code here
                // products(request,response);
                //Forward request & response to the main layout
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "checkout":
                //Processing code here
                // products(request,response);
                //Forward request & response to the main layout
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "orderHistory":
                orderHistory(request, response);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
              case "finish":
                break;      
            default:
            //Show error page
        }
    }

    protected void getList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductFacade pf = new ProductFacade();
            List<Product> list = pf.select();
            Collections.shuffle(list);
            request.setAttribute("list", list);
            //Forward request & response to the main layout
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            //Show the error page
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }
    }

    protected void products(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductFacade pf = new ProductFacade();
            BrandFacade bf = new BrandFacade();
            CategoryFacade cf = new CategoryFacade();
            int currentPage = 1;
            int recordsPerPage = 10;
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
            if (request.getAttribute("list") == null) {
                List<Product> list = pf.selectForEachPage(currentPage, recordsPerPage);
                request.setAttribute("list", list);
            }
            List<Brand> blist = bf.select();
            List<Category> clist = cf.select();
            //need to add the pf.cal all the row
            int numOfRecords = pf.countRows();
            int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("blist", blist);
            request.setAttribute("clist", clist);
            request.setAttribute("numOfPages", numOfPages);
            request.setAttribute("currentPage", currentPage);
            //Forward request & response to the main layout
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            //Show the error page
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }
    }

    private void orderHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            OrderFacade of = new OrderFacade();
            List<Order> list = of.readOrderHistory(account.getAccountId());
            request.setAttribute("list", list);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
