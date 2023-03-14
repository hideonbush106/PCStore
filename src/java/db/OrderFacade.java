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
                PreparedStatement stm3 = con.prepareStatement("insert into OrderDetail values((SELECT TOP 1 orderHeaderId from OrderHeader order by orderHeaderId desc),?,?,?)");
                stm3.setInt(1, item.getProduct().getProductId());
                stm3.setInt(2, item.getQuantity());
                stm3.setDouble(3, item.getCost());
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

    public List<Order> readOrder(int employeeId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Order> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT OrderHeader.OrderHeaderId AS OrderId, date, status, Customer.fullname AS fullname, Product.productName AS product, quantity, OrderDetail.price AS cost FROM OrderDetail INNER JOIN Product ON Product.ProductId = OrderDetail.ProductId INNER JOIN OrderHeader ON OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId INNER JOIN Customer ON Customer.CustomerId = OrderHeader.CustomerId WHERE OrderHeader.EmployeeId = ?");
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
}
