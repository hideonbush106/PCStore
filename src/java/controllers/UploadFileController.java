package controllers;

import db.ProductFacade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.MultipartConfigElement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.Product;

/**
 * Servlet implementation class UploadFileController
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10, // 10MB
                 maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet("/uploadFile")
public class UploadFileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        String productId=request.getParameter("id");
        ProductFacade pf=new ProductFacade();
       
        
            request.setAttribute("org.apache.catalina.multipartConfig", new MultipartConfigElement(""));
        // xử lý upload file khi người dùng nhấn nút thực hiện
        Collection<Part> parts = request.getParts();

        for (Part part : parts) {
            // Check if this part represents a file
            if (part.getContentType() != null && part.getName() != null && part.getSize() > 0) {
                InputStream inputStream = part.getInputStream();
                String dirUrl = request.getServletContext().getRealPath("") + File.separator + "images";
                dirUrl = dirUrl.replace("build\\web\\", "web\\");
               // String dirUrl = "E:\\Work";
                File dir = new File(dirUrl);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                String fileImg = dirUrl + File.separator + fileName;
                File file = new File(fileImg);
                try {
                    // write the file to the upload directory
                    part.write(fileImg);
                    System.out.println("product is "+ productId);
                    System.out.println("UPLOAD THÀNH CÔNG...!");
                    System.out.println("ĐƯỜNG DẪN KIỂM TRA UPLOAD HÌNH ẢNH : \n" + dirUrl);
                } catch (Exception e) {
                    System.out.println("CÓ LỖ TRONG QUÁ TRÌNH UPLOAD!");
                    e.printStackTrace();
                }
                
                
            }
        }
         try {
            Product product=pf.read(Integer.parseInt(productId));
            String imgSrc="/images/"+fileName;
            System.out.print(" img src "+product.getImgSrc());
            pf.updateImg(product,imgSrc);
             response.sendRedirect(request.getContextPath() + "/admin/products.do");
        } catch (SQLException ex) {
            Logger.getLogger(UploadFileController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }

}
