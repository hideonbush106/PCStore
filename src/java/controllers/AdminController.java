/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.AccountFacade;
import models.Brand;
import db.BrandFacade;
import db.CategoryFacade;
import db.CustomerFacade;
import db.EmployeeFacade;
import models.Product;
import db.ProductFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;
import models.Category;
import models.Customer;
import models.Employee;
import utils.Config;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AdminController", urlPatterns = {"/admin"})
public class AdminController extends HttpServlet {

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
                //Processing code here
                //Forward request & response to the main layout
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            case "products": //Processing code here
                products(request, response);
                break;
            case "employees":
                employees(request, response);
                break;
            case "customers":
                customers(request, response);
                break;
            case "createProduct": //Show the create form
                createProduct(request, response);
                break;
            case "create_handlerProduct": //Process the create form
                create_handlerProduct(request, response);
                break;
            case "editProduct": //Show the edit form
                editProduct(request, response);
                break;
            case "edit_handlerProduct": //Process the edit form
                edit_handlerProduct(request, response);
                break;
            case "deleteProduct": //Show delettion confirmation form
                deleteProduct(request, response);
                break;
            case "delete_handlerProduct": //Process delettion confirmation form
                delete_handlerProduct(request, response);
                break;
            case "editEmployee":
                editEmployee(request, response);
                break;
            case "edit_handlerEmployee":
                edit_handlerEmployee(request, response);
                break;
            case "createEmployee": //Show the create form
                createEmployee(request, response);
                break;
            case "create_handlerEmployee":
                create_handlerEmployee(request, response);
                break;
            default:
                default_handler(request, response);
        }
    }

    protected void products(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int currentPage = 1;
            int recordsPerPage = 10;
            if(request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
            ProductFacade pf = new ProductFacade();
            List<Product> list = pf.selectForEachPage(currentPage, recordsPerPage);
            //need to add the pf.cal all the row
            int numOfRecords = pf.countRows();
            int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("list", list);
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

    protected void employees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmployeeFacade ef = new EmployeeFacade();
            List<Employee> list = ef.select();
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

    protected void customers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CustomerFacade cf = new CustomerFacade();
            List<Customer> list = cf.select();
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

    protected void createProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //lay list brand
            BrandFacade bf = new BrandFacade();
            List<Brand> bList = bf.select();
            request.setAttribute("brandList", bList);
            //lay list category
            CategoryFacade cf = new CategoryFacade();
            List<Category> cList = cf.select();
            request.setAttribute("categoryList", cList);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("action", "create");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }

    }

    protected void create_handlerProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
                    //Lay data tu client
                    String productName = request.getParameter("productName");
                    double price = Double.parseDouble(request.getParameter("price"));
                    int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                    String description = request.getParameter("description");
                    int brandId = Integer.parseInt(request.getParameter("brandId"));
                    //Tao doi tuong Product
                    Product product = new Product(productName, price, categoryId, brandId, description);
                    //Luu toy vao request de bao ton trang thai cua form
                    request.setAttribute("product", product);
                    //Insert toy vao db
                    ProductFacade pf = new ProductFacade();
                    pf.create(product);
                    //Hien danh sach Product
                    response.sendRedirect(request.getContextPath() + "/admin/products.do");
                } catch (SQLException ex) {
                    //Show the error page
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "createProduct");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
            case "cancel":
                //Hien danh sach Product
                response.sendRedirect(request.getContextPath() + "/admin/products.do");
                break;
        }
    }

    protected void editProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Lay id tu client
            int id = Integer.parseInt(request.getParameter("id"));
            //Doc mau tin toy tuong ung voi id
            ProductFacade pf = new ProductFacade();
            Product product = pf.read(id);
            //Doc toan bo table brand
            //lay list brand
            BrandFacade bf = new BrandFacade();
            List<Brand> bList = bf.select();
            request.setAttribute("brandList", bList);
            //lay list category
            CategoryFacade cf = new CategoryFacade();
            List<Category> cList = cf.select();
            request.setAttribute("categoryList", cList);
            request.setAttribute("product", product);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            //Show the error page
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }
    }

    protected void edit_handlerProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    //Lay data tu client
                    int productId = Integer.parseInt(request.getParameter("productId"));
                    String productName = request.getParameter("productName");
                    double price = Double.parseDouble(request.getParameter("price"));
                    int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                    int brandId = Integer.parseInt(request.getParameter("brandId"));
                    String description = request.getParameter("description");
                    Product product = new Product(productId, productName, price, categoryId, brandId, description);
                    ProductFacade pf = new ProductFacade();
                    pf.update(product);
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

    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void delete_handlerProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "yes":
                int id = Integer.parseInt(request.getParameter("id"));
                ProductFacade pf = new ProductFacade();
                try {
                    pf.delete(id);
                    response.sendRedirect(request.getContextPath() + "/admin/products.do");
                } catch (SQLException ex) {
                    //Show the error page
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
            case "no":
                response.sendRedirect(request.getContextPath() + "/admin/products.do");
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeFacade ef = new EmployeeFacade();
            Employee employee = ef.read(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            //Show the error page
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }
    }

    private void edit_handlerEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
                    double salary = Double.parseDouble(request.getParameter("salary"));
                    Employee employee = new Employee(employeeId, salary);
                    EmployeeFacade ef = new EmployeeFacade();
                    ef.update(employee);
                    response.sendRedirect(request.getContextPath() + "/admin/employees.do");
                } catch (SQLException ex) {
                    ex.printStackTrace();//In chi tiet ve ngoai le cho developer
                    request.setAttribute("message", "Can not save this salary.");
                    request.setAttribute("action", "edit");
                    request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/admin/employees.do");
                break;
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    private void create_handlerEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    //Lay thong tin register
                    AccountFacade af = new AccountFacade();
                    EmployeeFacade ef = new EmployeeFacade();
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String empName = request.getParameter("empName");
                    double salary = Double.parseDouble(request.getParameter("salary"));
                    String address = request.getParameter("address");
                    String phoneNo = request.getParameter("phoneNo");
                    boolean cont = true;
                    //Kiem tra thong trong DB
                    Account account = new Account(email, password, empName, address, phoneNo);
                    List<Account> list = af.readEmail();
                    if (email == "" || password == "" || empName == "" || address == "" || phoneNo == "") {
                        request.setAttribute("message", "Please fulfill the form");
                        request.getRequestDispatcher("/admin/createEmployees.do").forward(request, response);
                    } else {
                        for (Account accountEmail : list) {
                            System.out.println(accountEmail.getEmail());
                            if (accountEmail.getEmail().equals(email)) {
                                request.setAttribute("message", "Email da dang ki");
                                cont = false;
                                request.getRequestDispatcher("/admin/createEmployee.do").forward(request, response);
                            }
                        }

                    }
                    if (cont) {
                        af.registerEmployee(account);
                        Account employeeId = af.readId(email);
                        Employee employee = new Employee(employeeId.getAccountId(), empName, salary, address, phoneNo);
                        ef.create(employee);
                        response.sendRedirect(request.getContextPath() + "/admin/employees.do");
                    }
                    break;
                case "cancel":
                    response.sendRedirect(request.getContextPath() + "/admin/employees.do");
                    break;
                default:
            }
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/admin/createEmployee.do").forward(request, response);
        }
    }

    protected void default_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Show the error page
        request.setAttribute("message", "Invalid request.");
        request.setAttribute("controller", "error");
        request.setAttribute("action", "error");
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
