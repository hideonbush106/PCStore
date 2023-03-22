/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.CustomerFacade;
import db.OrderFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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
import models.Customer;
import models.Order;
import models.OrderHeader;
import utils.Config;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/employees"})
public class EmployeeController extends HttpServlet {

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
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "index":
                //Processing code here
                //Forward request & response to the main layout
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "orderList":
                //Processing code here
                orderList(request, response);
                break;
            case "invoice":
                invoice(request, response);
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
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void orderList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        OrderFacade of = new OrderFacade();
        CustomerFacade cf = new CustomerFacade();
        List<Order> orderList = of.readOrderForEmployee(account.getAccountId());
        request.setAttribute("orderList", orderList);
        List<Customer> customerList = cf.select();
        request.setAttribute("customerList", customerList);
        //Forward request & response to the main layout
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    private void invoice(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "invoice": {
                int customerId = Integer.parseInt(request.getParameter("customerId"));
                OrderFacade of = new OrderFacade();
                List<Order> orderDate = of.readOrderForCustomer(customerId);
                CustomerFacade cf = new CustomerFacade();
                Customer customer = cf.read(customerId);
                request.setAttribute("customer", customer);
                request.setAttribute("orderDate", orderDate);
                request.setAttribute("customerId", customerId);
                break;
            }
            case "export": {
                int customerId = Integer.parseInt(request.getParameter("customerId"));
                int orderHeaderId = Integer.parseInt(request.getParameter("orderHeaderId"));

                if (orderHeaderId == -1) {
                    request.setAttribute("controller", "employees");
                    request.setAttribute("action", "index");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }

                OrderFacade of = new OrderFacade();
                List<Order> orderDate = of.readOrderForCustomer(customerId);
                List<Order> orderList = of.exportInvoice(orderHeaderId);
                CustomerFacade cf = new CustomerFacade();
                Customer customer = cf.read(customerId);

                Date date = of.getDate(orderHeaderId);
                request.setAttribute("date", date);
                request.setAttribute("orderDate", orderDate);
                request.setAttribute("orderList", orderList);
                request.setAttribute("customer", customer);
                request.setAttribute("customerId", customerId);
                request.setAttribute("orderHeaderId", orderHeaderId);
                break;
            }
            case "print": {
//                int orderHeaderId = Integer.parseInt(request.getParameter("orderHeaderId"));
                OrderFacade of = new OrderFacade();
                int orderHeaderId = Integer.parseInt(request.getParameter("orderHeaderId"));
                of.setStatus(orderHeaderId);
                request.setAttribute("controller", "employees");
                request.setAttribute("action", "index");
                break;
            }
        }
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

}
