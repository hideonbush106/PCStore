/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Account;
import db.AccountFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Config;

/**
 *
 * @author PHT
 */
@WebServlet(name = "AccountController", urlPatterns = {"/account"})
public class AccountController extends HttpServlet {

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
                //Hien login form                
                request.getRequestDispatcher(Config.LOGIN).forward(request, response);
                break;
            case "login_handler":
                //Xu ly login form
                login_handler(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            default:
            //Show error page
        }
    }

    protected void login_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "login":
                    //Lay thong tin login
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    //Kiem tra thong trong DB
                    AccountFacade af = new AccountFacade();
                    Account account = af.login(email, password);
                    if (account == null) {
                        //Neu login khong thanh cong thi quay ve login form 
                        //de nhap lai thong tin
                        request.setAttribute("message", "Incorrect email or password.");
                        request.getRequestDispatcher("/account/login.do").forward(request, response);
                    }else{
                        //Neu login thanh cong
                        //Luu account vao session
                        HttpSession session = request.getSession();
                        session.setAttribute("account", account);
                        //Quay ve Home Page
                        response.sendRedirect(request.getContextPath() + "/home/index.do");
                    }
                    //
                    break;
                case "cancel":
                    //Quay ve Home Page
                    response.sendRedirect(request.getContextPath() + "/home/index.do");
                    break;
            }
        } catch (Exception ex) {
            //Quay ve login form de thong bao loi
            request.setAttribute("message", ex.toString());
            request.getRequestDispatcher("/account/login.do").forward(request, response);
        }
    }
    
    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Xoa session
        HttpSession session = request.getSession();
        session.invalidate();
        //Quay ve trang chu
        response.sendRedirect(request.getContextPath() + "/home/index.do");
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
