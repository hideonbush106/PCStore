/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import models.Cart;
import models.Customer;
import models.Employee;
import models.Item;
import models.OrderDetail;
import models.OrderHeader;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class CartFacade {
    public void addOrderHeader(Customer customer, Employee employee,OrderHeader orderHeader) throws SQLException{
        Connection con = DBContext.getConnection();
        con.setAutoCommit(false);
        try{
            PreparedStatement stm = con.prepareStatement("insert into orderheader (date,status,customerId,employeeId) values (?,?,?,?)");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            stm.setString(1,sdf.format(orderHeader.getDate()));
            stm.setString(2,orderHeader.getStatus());
            stm.setInt(3,customer.getCustomerId());
            stm.setInt(4,employee.getEmployeeId());
            int affectedRows = stm.executeUpdate();
            if (affectedRows == 0){
                 throw new SQLException("Creating order failed, no rows affected.");
            }
            con.commit();  
        }
        catch(Exception e){
            e.printStackTrace();
            con.rollback();
        }
        finally {
            con.close();
        }
    }
    public void addOrderDetail(Item item, OrderHeader orderHeader) throws SQLException{
        Connection con = DBContext.getConnection();
        con.setAutoCommit(false);
        try{
            PreparedStatement stm = con.prepareStatement("insert into orderdetail (orderHeader,productId,quantity,price) values (?,?,?,?)");
            stm.setInt(1,orderHeader.getOrderHeaderId());
            stm.setInt(2,item.getProduct().getProductId());
            stm.setInt(3,item.getQuantity());
            stm.setDouble(4,item.getProduct().getPrice());
            int affectedRows = stm.executeUpdate();
            if (affectedRows == 0){
                 throw new SQLException("Creating order failed, no rows affected.");
            }
            con.commit();  
        }
        catch(Exception e){
            e.printStackTrace();
            con.rollback();
        }
        finally {
            con.close();
        }
    }
    

    public void checkout(Customer customer, Employee employee,OrderHeader orderHeader,Item item) throws SQLException {
        Connection con = DBContext.getConnection();
        con.setAutoCommit(false);
        try {
            addOrderHeader(customer, employee, orderHeader);
            addOrderDetail(item, orderHeader);
            con.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        } finally {
            con.close();
        }
    }
}
