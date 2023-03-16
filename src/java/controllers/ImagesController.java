/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.ImagesFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
import models.Images;
import utils.Config;

/**
 *
 * @author trung
 */
@WebServlet(name = "ImagesController", urlPatterns = {"/images"})
public class ImagesController extends HttpServlet {

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
            case "upload":
                upload(request, response);
                break;
            case "upload_handler":
                upload_handler(request, response);
                break;
        }
    }

    protected void upload(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            //lay list brand
            ImagesFacade imf = new ImagesFacade();
            List<Images> iList = imf.select();
            request.setAttribute("imgList", iList);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("action", "create");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Lay id tu client
            int imgId = Integer.parseInt(request.getParameter("imgId"));
            //Doc mau tin toy tuong ung voi id
            ImagesFacade imf = new ImagesFacade();
            Images images  = imf.read(imgId);
            request.setAttribute("images", images);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            //Show the error page
            request.setAttribute("message", ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ImagesController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ImagesController.class.getName()).log(Level.SEVERE, null, ex);
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

    protected void upload_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "upload":
                try {
                    int productId = Integer.parseInt(request.getParameter("productId"));
                    String imgSrc = request.getParameter("imgSrc");
                    Images images = new Images(productId, imgSrc);
                    request.setAttribute("images", images);
                    ImagesFacade imf = new ImagesFacade();
                    imf.uploadImage(images);
                    response.sendRedirect(request.getContextPath() + "/admin/products.do");
                } catch (SQLException ex) {
                    //Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
        }

    }

    protected void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "upload":
                try {
                    int productId = Integer.parseInt(request.getParameter("productId"));
                    String imgSrc = request.getParameter("imgSrc");
                    Images images = new Images(productId, imgSrc);
                    ImagesFacade imf = new ImagesFacade();
                    imf.updateImage(images);
                    response.sendRedirect(request.getContextPath() + "/admin/products.do");
                } catch (SQLException ex) {
                    ex.printStackTrace();//In chi tiet ve ngoai le cho developer
                    request.setAttribute("message", "Can not save this product. Please check the product data.");
                    request.setAttribute("action", "edit");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/admin/products.do");
                break;
        }

    }

}
