/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Product;

/**
 *
 * @author trung
 */
public class ProductFacade {

    public List<Product> select() throws SQLException {
        List<Product> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product INNER JOIN Brand ON Product.BrandId = Brand.BrandId INNER JOIN Category ON Product.CategoryId = Category.CategoryId");
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }

    public List<Product> selectForEachPage(int page, int number) throws SQLException {
        int offset = (page - 1) * number;
        List<Product> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        String sql = "SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc "
                + "FROM Product INNER JOIN Brand ON Product.BrandId = Brand.BrandId " + ""
                + "INNER JOIN Category ON Product.CategoryId = Category.CategoryId " + ""
                + "ORDER BY ProductId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
        PreparedStatement stm = con.prepareStatement(sql);
        //Thực thi lệnh SELECT
        stm.setInt(1, offset);
        stm.setInt(2, number);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }

    public void create(Product product) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert product values (?,?,?,?,?,?)");
        stm.setString(1, product.getProductName());
        stm.setDouble(2, product.getPrice());
        stm.setInt(3, product.getCategoryId());
        stm.setInt(4, product.getBrandId());
        stm.setString(5, product.getDescription());
        stm.setString(6, product.getImgSrc());
        int count = stm.executeUpdate();
        con.close();
    }

    public Product read(int productId) throws SQLException {
        Product product = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("SELECT ProductId, productName, price,Product.CategoryId,Product.BrandId, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product INNER JOIN Brand ON Product.BrandId = Brand.BrandId INNER JOIN Category ON Product.CategoryId = Category.CategoryId where ProductId= ?"
                + " ");
        //Thực thi lệnh SELECT
        stm.setInt(1, productId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong product
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
            product.setBrandId(rs.getInt("brandId"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
        }
        con.close();
        return product;
    }

    public void delete(int productId) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("delete from product where productId = ?");
        //Thực thi lệnh 
        stm.setInt(1, productId);
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public void update(Product product) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update product set productName = ?, price = ?, categoryId = ?, brandId = ?, description = ?,imgSrc = ? where productId = ?");
        stm.setString(1, product.getProductName());
        stm.setDouble(2, product.getPrice());
        stm.setInt(3, product.getCategoryId());
        stm.setInt(4, product.getBrandId());
        stm.setString(5, product.getDescription());
        stm.setString(6, product.getImgSrc());
        stm.setInt(7, product.getProductId());
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public int countRows() throws SQLException {
        int count = 0;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("SELECT COUNT(ProductId) FROM dbo.PRODUCT;");
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery();
        //Doc mau tin hien hanh de vao doi tuong toy
        while (rs.next()) {
            count = rs.getInt(1);
            //Them toy vao list

        }
        con.close();
        return count;
    }

    public Product readForCart(int productId) throws SQLException {
        Product product = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product INNER JOIN Brand ON Product.BrandId = Brand.BrandId INNER JOIN Category ON Product.CategoryId = Category.CategoryId WHERE ProductId = ?");
        //Thực thi lệnh SELECT
        stm.setInt(1, productId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong product
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
        }
        con.close();
        return product;
    }

    public Integer getCategoryId(int productId) throws SQLException {
        int id = 0;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("select * from dbo.product where productid= ?");
        //Thực thi lệnh SELECT
        stm.setInt(1, productId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            id = rs.getInt("categoryId");
        }
        while (rs.next()) {

        }
        con.close();
        return id;
    }

    public List<Product> relatedProducts(int productId) throws SQLException {
        List<Product> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product INNER JOIN Brand ON Product.BrandId = Brand.BrandId INNER JOIN Category ON Product.CategoryId = Category.CategoryId where Product.categoryId= ?");
        stm.setInt(1, productId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }

    public List<Product> search(String searchName, int page, int number) throws SQLException {
        int offset = (page - 1) * number;
        String query = "%" + searchName + "%";
        List<Product> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        //Thực thi lệnh SELECT
        String sql = "SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product"
                + " INNER JOIN Brand ON Product.BrandId = Brand.BrandId"
                + " INNER JOIN Category ON Product.CategoryId = Category.CategoryId"
                + " WHERE productName LIKE ? OR Brand.name LIKE ? OR Category.name LIKE ?"
                + " ORDER BY ProductId desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, query);
        stm.setString(2, query);
        stm.setString(3, query);
        stm.setInt(4, offset);
        stm.setInt(5, number);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }

    public List<Product> search(String searchName) throws SQLException {
        String query = "%" + searchName + "%";
        List<Product> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        //Thực thi lệnh SELECT
        String sql = "SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product"
                + " INNER JOIN Brand ON Product.BrandId = Brand.BrandId"
                + " INNER JOIN Category ON Product.CategoryId = Category.CategoryId"
                + " WHERE productName LIKE ? OR Brand.name LIKE ? OR Category.name LIKE ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, query);
        stm.setString(2, query);
        stm.setString(3, query);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }

    public List<Product> sort(String sortBy, String sortDirection) throws SQLException {
        List<Product> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        String sql = "SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product"
                + " INNER JOIN Brand ON Product.BrandId = Brand.BrandId"
                + " INNER JOIN Category ON Product.CategoryId = Category.CategoryId"
                + " ORDER BY " + sortBy + " " +  sortDirection;
        //Tạo đối tượng statement
        //Thực thi lệnh SELECT
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }

    public List<Product> sort(String sortBy, String sortDirection, int page, int number) throws SQLException {
        List<Product> list = null;
        int offset = (page - 1) * number;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        String sql = "SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product"
                + " INNER JOIN Brand ON Product.BrandId = Brand.BrandId"
                + " INNER JOIN Category ON Product.CategoryId = Category.CategoryId"
                + " ORDER BY " + sortBy + " " + sortDirection
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        //Tạo đối tượng statement
        //Thực thi lệnh SELECT

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, offset);
        stm.setInt(2, number);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }

    public List<Product> filter(String brandName, String categoryName) throws SQLException {
        String queryBrand = "%" + brandName + "%";
        String queryCategory = "%" + categoryName + "%";
        System.out.println(queryBrand + queryCategory);
        List<Product> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        String sql = "SELECT ProductId, productName, price, category.name AS categoryName, brand.name as brandName, description, imgSrc FROM Product"
                + " INNER JOIN Brand ON Product.BrandId = Brand.BrandId"
                + " INNER JOIN Category ON Product.CategoryId = Category.CategoryId"
                + " WHERE brand.name LIKE ? AND category.name LIKE ?";
        //Tạo đối tượng statement
        //Thực thi lệnh SELECT
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, queryBrand);
        stm.setString(2, queryCategory);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryName(rs.getString("categoryName"));
            product.setBrandName(rs.getString("brandName"));
            product.setDescription(rs.getString("description"));
            product.setImgSrc(rs.getString("imgSrc"));
            //Them toy vao list
            list.add(product);
        }
        con.close();
        return list;
    }
}
