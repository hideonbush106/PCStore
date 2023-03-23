/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import models.Cart;
import models.Customer;
import models.Employee;
import models.Item;
import models.Order;
import models.OrderDetail;
import models.OrderHeader;
import models.Product;
import utils.DBContext;

/**
 *
 * @author Administrator
 */
public class OrderFacade {

    public void addOrder(Customer customer, Cart cart, OrderHeader orderHeader, Employee employee) throws SQLException {
        Connection con = DBContext.getConnection();
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            PreparedStatement stm = con.prepareStatement("insert into OrderHeader values(?,?,?,?)");
            stm.setString(1, date);
            stm.setBoolean(2, orderHeader.isStatus());
            stm.setInt(3, customer.getCustomerId());
            stm.setInt(4, employee.getEmployeeId());
            stm.executeUpdate();
            Collection<Item> items = cart.getItem();
            for (Item item : items) {
                System.out.println(item.getProduct().getProductId());
                PreparedStatement stm2 = con.prepareStatement("insert into OrderDetail values((SELECT TOP 1 orderHeaderId from OrderHeader order by orderHeaderId desc),?,?,?)");
                stm2.setInt(1, item.getProduct().getProductId());
                stm2.setInt(2, item.getQuantity());
                stm2.setDouble(3, item.getCost());
                stm2.executeUpdate();
            }
            PreparedStatement stm3 = con.prepareStatement("update product set quantity = quantity - ? where productId = ?");
            for (Item item : items) {
                stm3.setInt(1, item.getQuantity());
                stm3.setInt(2, item.getProduct().getProductId());
                stm3.executeUpdate();
            }
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        } finally {
            con.close();
        }
    }

    public List<Order> readOrderForEmployee(int employeeId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Order> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT OrderHeader.OrderHeaderId AS OrderId, date, status, Customer.fullname AS fullname, Product.productName AS product, OrderDetail.quantity as quantity, OrderDetail.price AS cost "
                + "FROM OrderDetail "
                + "INNER JOIN Product ON Product.ProductId = OrderDetail.ProductId "
                + "INNER JOIN OrderHeader ON OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId "
                + "INNER JOIN Customer ON Customer.CustomerId = OrderHeader.CustomerId WHERE OrderHeader.EmployeeId = ?");
        stm.setInt(1, employeeId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setOrderHeaderId(rs.getInt("OrderId"));
            order.setDate(rs.getDate("date"));
            order.setStatus(rs.getBoolean("status"));
            order.setFullname(rs.getString("fullname"));
            order.setProductName(rs.getString("product"));
            order.setQuantity(rs.getInt("quantity"));
            order.setPrice(rs.getDouble("cost"));
            list.add(order);
        }
        con.close();
        return list;
    }

    public List<Order> readOrderHistory(int customerId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Order> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT OrderHeader.OrderHeaderId AS OrderId, date, status, Customer.fullname AS fullname, Product.productName AS product, OrderDetail.quantity as quantity, OrderDetail.price AS cost "
                + "FROM OrderDetail "
                + "INNER JOIN Product ON Product.ProductId = OrderDetail.ProductId "
                + "INNER JOIN OrderHeader ON OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId "
                + "INNER JOIN Customer ON Customer.CustomerId = OrderHeader.CustomerId WHERE OrderHeader.CustomerId = ?");
        stm.setInt(1, customerId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setOrderHeaderId(rs.getInt("OrderId"));
            order.setDate(rs.getDate("date"));
            order.setStatus(rs.getBoolean("status"));
            order.setFullname(rs.getString("fullname"));
            order.setProductName(rs.getString("product"));
            order.setQuantity(rs.getInt("quantity"));
            order.setPrice(rs.getDouble("cost"));
            list.add(order);
        }
        con.close();
        return list;
    }

    public List<Order> readOrderForCustomer(int customerId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Order> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT DISTINCT OrderHeader.OrderHeaderId AS OrderId, date "
                + "FROM OrderDetail "
                + "INNER JOIN Product ON Product.ProductId = OrderDetail.ProductId "
                + "INNER JOIN OrderHeader ON OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId "
                + "INNER JOIN Customer ON Customer.CustomerId = OrderHeader.CustomerId WHERE OrderHeader.CustomerId = ? AND status = 1");
        stm.setInt(1, customerId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setOrderHeaderId(rs.getInt("OrderId"));
            order.setDate(rs.getDate("date"));
            list.add(order);
        }
        con.close();
        return list;
    }

    public List<Order> exportInvoice(int orderHeaderId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Order> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT OrderHeader.OrderHeaderId AS OrderId, date, status, Customer.fullname AS fullname, Product.productName AS product, OrderDetail.quantity as quantity, OrderDetail.price AS cost "
                + "FROM OrderDetail "
                + "INNER JOIN Product ON Product.ProductId = OrderDetail.ProductId "
                + "INNER JOIN OrderHeader ON OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId "
                + "INNER JOIN Customer ON Customer.CustomerId = OrderHeader.CustomerId WHERE OrderHeader.OrderHeaderId = ? AND status = 1");
        stm.setInt(1, orderHeaderId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setOrderHeaderId(rs.getInt("OrderId"));
            order.setDate(rs.getDate("date"));
            order.setStatus(rs.getBoolean("status"));
            order.setFullname(rs.getString("fullname"));
            order.setProductName(rs.getString("product"));
            order.setQuantity(rs.getInt("quantity"));
            order.setPrice(rs.getDouble("cost"));
            list.add(order);
        }
        con.close();
        return list;
    }

    public Date getDate(int orderHeaderId) throws SQLException {
        Connection con = DBContext.getConnection();
        Date date = null;
        PreparedStatement stm = con.prepareStatement("SELECT DISTINCT date "
                + "FROM OrderDetail "
                + "INNER JOIN Product ON Product.ProductId = OrderDetail.ProductId "
                + "INNER JOIN OrderHeader ON OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId "
                + "INNER JOIN Customer ON Customer.CustomerId = OrderHeader.CustomerId WHERE OrderHeader.OrderHeaderId = ?");
        stm.setInt(1, orderHeaderId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            date = rs.getDate("date");
        }
        con.close();
        return date;
    }

    public void setStatus(int orderHeaderId) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE OrderHeader SET status = 0 WHERE OrderHeader.OrderHeaderId = ?");
        stm.setInt(1, orderHeaderId);
        int count = stm.executeUpdate();
        con.close();
    }
     public List<OrderHeader> readOrderHeaderHistory(int customerId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<OrderHeader> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT * FROM OrderHeader WHERE customerId= ?");
        stm.setInt(1, customerId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            OrderHeader orderHeader = new OrderHeader();
            orderHeader.setOrderHeaderId(rs.getInt("OrderHeaderId"));
            orderHeader.setDate(rs.getDate("date"));
            orderHeader.setStatus(rs.getBoolean("status"));
            list.add(orderHeader);
        }
        con.close();
        return list;
    }
     public List<Order> readOrderDetail(int orderId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Order> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT od.*, p.productname FROM OrderDetail od JOIN Product p ON od.productid = p.productid WHERE od.orderheaderid = ?");
        stm.setInt(1, orderId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setOrderHeaderId(rs.getInt("orderdetailid"));
            order.setProductName(rs.getString("productname"));
            order.setQuantity(rs.getInt("quantity"));
            order.setPrice(rs.getDouble("price"));
            list.add(order);
        }
       con.close();
        return list;
    }
     public static void main(String[] args) throws SQLException {
         OrderFacade of= new OrderFacade();
         int id=20;
         List<Order> list = of.readOrderDetail(id);
         System.out.print(list);
    }

}

