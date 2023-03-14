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

    public List<OrderHeader> readOrderHeader(int employeeId) throws SQLException {
        Connection con = DBContext.getConnection();
        List<OrderHeader> list = null;
        PreparedStatement stm = con.prepareStatement("SELECT DISTINCT OrderHeader.OrderHeaderId AS OrderId, date, status, Customer.fullname AS customerName FROM OrderHeader INNER JOIN OrderDetail ON OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId INNER JOIN Employee ON Employee.EmployeeId = OrderHeader.EmployeeId INNER JOIN Product ON Product.ProductId = OrderDetail.ProductId INNER JOIN Customer ON Customer.CustomerId = OrderHeader.CustomerId WHERE Employee.EmployeeId = ?");
        stm.setInt(1, employeeId);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            OrderHeader orderHeader = new OrderHeader();
            orderHeader.setOrderHeaderId(rs.getInt("OrderId"));
            orderHeader.setDate(rs.getDate("date"));
            orderHeader.setStatus(rs.getBoolean("status"));
            orderHeader.setCustomerName(rs.getString("customerName"));
            list.add(orderHeader);
        }
        con.close();
        return list;
    }
}
