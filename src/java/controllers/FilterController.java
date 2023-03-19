/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.BrandFacade;
import db.CategoryFacade;
import db.ProductFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Brand;
import models.Category;
import models.Product;
import utils.Config;

/**
 *
 * @author Admin
 */
@WebServlet(name = "FilterController", urlPatterns = {"/filter"})
public class FilterController extends HttpServlet {

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
        String op = (String) request.getParameter("op");
        HttpSession session = request.getSession();
        switch (op) {
            case "search": {
                String searchName = (String) request.getParameter("searchName");
                //TODO: write search (contains name and brand)
                session.setAttribute("searchName", searchName);
                int currentPage = 1;
                int recordsPerPage = 10;
                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }
                ProductFacade pf = new ProductFacade();
                List<Product> list = pf.search(searchName, currentPage, recordsPerPage); //change to sort, search, filter...
                int numOfRecords = pf.search(searchName).size();
                int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
                request.setAttribute("numOfPages", numOfPages);
                request.setAttribute("currentPage", currentPage);

                BrandFacade bf = new BrandFacade();
                CategoryFacade cf = new CategoryFacade();
                List<Brand> blist = bf.select();
                List<Category> clist = cf.select();
                request.setAttribute("blist", blist);
                request.setAttribute("clist", clist);
                session.setAttribute("list", list);
                request.setAttribute("action", "product");
                request.setAttribute("controller", "home");
                request.setAttribute("searchName", searchName);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "sort": {
                //TODO: wrtie sort bt name, product or price, asc or desc
                String sortDirection = (String) request.getParameter("sortDirection");
                String sortBy = (String) request.getParameter("sortBy");
                int currentPage = 1;
                int recordsPerPage = 10;
                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }
                ProductFacade pf = new ProductFacade();
                List<Product> list = pf.sort(sortBy, sortDirection, currentPage, recordsPerPage); //change to sort, search, filter...
                int numOfRecords = pf.sort(sortBy, sortDirection).size();
                int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
                request.setAttribute("numOfPages", numOfPages);
                request.setAttribute("currentPage", currentPage);
                BrandFacade bf = new BrandFacade();
                CategoryFacade cf = new CategoryFacade();
                List<Brand> blist = bf.select();
                List<Category> clist = cf.select();
                request.setAttribute("blist", blist);
                request.setAttribute("clist", clist);
                session.setAttribute("list", list);
                request.setAttribute("action", "product");
                request.setAttribute("controller", "home");
                request.setAttribute("sortDirection", sortDirection);
                request.setAttribute("sortBy", sortBy);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "filter": {
                String brandName = (String) request.getParameter("brandName");
                String categoryName = (String) request.getParameter("categoryName");
                ProductFacade pf = new ProductFacade();
                List<Product> list = pf.filter(brandName, categoryName);
                BrandFacade bf = new BrandFacade();
                CategoryFacade cf = new CategoryFacade();
                List<Brand> blist = bf.select();
                List<Category> clist = cf.select();
                request.setAttribute("blist", blist);
                request.setAttribute("clist", clist);
                session.setAttribute("list", list);
                request.setAttribute("action", "product");
                request.setAttribute("controller", "home");
                request.setAttribute("brandName", brandName);
                request.setAttribute("categoryName", categoryName);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
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
            Logger.getLogger(FilterController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FilterController.class.getName()).log(Level.SEVERE, null, ex);
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
