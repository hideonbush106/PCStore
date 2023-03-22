/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.CustomerFacade;
import db.OrderFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cart;
import models.Item;
import models.Product;
import db.ProductFacade;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;
import models.Customer;
import models.Employee;
import models.OrderHeader;
import utils.Config;

/**
 *
 * @author trung
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException {

        //String url = response.encodeURL("index.jsp");
        //response.sendRedirect(url);
        //or
        //String url = response.encodeRedirectURL("index.jsp");
        //response.sendRedirect(url);
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
            case "update":
                update(request, response);
                break;
            case "checkout":
                checkout(request, response);
                break;
        }

    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductFacade pf = new ProductFacade();
        Product product = pf.readForCart(productId);
        if (product.getQuantity() == 0) {
            request.setAttribute("message", "This product is out of stock !");
            request.setAttribute("controller", "home");
            request.setAttribute("action", "product");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } else {
            Item item = new Item(product, 1);
            //Lay cart tu session
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                //neu session chua co cart thi tao moi 
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            //them item vao cart
            cart.add(item);
            //quay ve trang index.jsp
            request.setAttribute("controller", "home");
            request.setAttribute("action", "product");
            List<Product> list = pf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.remove(id);
        if (cart.getMap().isEmpty()) {
            request.setAttribute("message", "Cart empty");
        }
        request.setAttribute("controller", "home");
        request.setAttribute("action", "cart");
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void empty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.empty();
        request.setAttribute("controller", "home");
        request.setAttribute("action", "cart");
        if (cart.getMap().isEmpty()) {
            request.setAttribute("message", "Cart empty");
        }
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.update(id, quantity);
        request.setAttribute("controller", "home");
        request.setAttribute("action", "cart");
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void checkout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        Cart cart = (Cart) session.getAttribute("cart");
        OrderFacade of = new OrderFacade();
        CustomerFacade cf = new CustomerFacade();
        Customer customer = cf.read(account.getAccountId());
        //dang gan mac dinh status don hang la true
        OrderHeader orderHeader = new OrderHeader(true);
        //dang gan mac dinh employee 2
        Employee employee = new Employee(3);

        if (account == null) {
            request.setAttribute("action", "login");
            request.getRequestDispatcher(Config.LOGIN).forward(request, response);
        }
        of.addOrder(customer, cart, orderHeader, employee);
        cart.empty();
        request.setAttribute("controller", "home");
        request.setAttribute("action", "product");
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
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
            Logger.getLogger(CartController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CartController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CartController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CartController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
