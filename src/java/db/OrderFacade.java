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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
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
            PreparedStatement stm2 = con.prepareStatement("SELECT TOP 1 orderHeaderId from OrderHeader order by orderHeaderId desc");
            ResultSet rs = stm2.executeQuery();
            if (rs.next()) {
                int orderHeaderId = rs.getInt("orderHeaderId");
                Collection<Item> items = cart.getItem();
                for (Item item : items) {
                  PreparedStatement stm3 = con.prepareStatement("insert into OrderDetail values(?,?,?,?)");  
                  stm3.setInt(1,orderHeaderId);
                  stm3.setInt(2,item.getProduct().getProductId());
                  stm3.setInt(3,item.getQuantity());
                  stm3.setDouble(4,item.getCost());
                }
            }

            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        } finally {
            con.close();
        }
    }
}
