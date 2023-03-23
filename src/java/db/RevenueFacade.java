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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.Revenue;
import utils.DBContext;

/**
 *
 * @author Administrator
 */
public class RevenueFacade {

    public List<Revenue> readOrder() throws SQLException {
        Connection con = DBContext.getConnection();
        List<Revenue> list = new ArrayList<>();
        PreparedStatement stm = con.prepareStatement("SELECT OrderDetailId, date, OrderDetail.ProductId as productId, productName, OrderDetail.quantity as quantity, OrderDetail.price as cost from OrderHeader inner join OrderDetail on OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId inner join Product on OrderDetail.productId = Product.productid");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Revenue revenue = new Revenue();
            revenue.setOrderDetailId(rs.getInt("OrderDetailId"));
            revenue.setDate(rs.getDate("date"));
            revenue.setProductId(rs.getInt("productId"));
            revenue.setProductName(rs.getString("productName"));
            revenue.setQuantity(rs.getInt("quantity"));
            revenue.setCost(rs.getDouble("cost"));
            list.add(revenue);
        }
        con.close();
        return list;
    }

    public List<Revenue> readBetweenDate(Date dateFrom, Date dateTo) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Revenue> list = new ArrayList<>();
        PreparedStatement stm = con.prepareStatement("SELECT OrderDetailId, date, OrderDetail.ProductId as productId, productName, OrderDetail.quantity as quantity, OrderDetail.price as cost from OrderHeader inner join OrderDetail on OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId inner join Product on OrderDetail.productId = Product.productid WHERE date BETWEEN ? AND ?");
        stm.setDate(1, new java.sql.Date(dateFrom.getTime()));
        stm.setDate(2, new java.sql.Date(dateTo.getTime()));
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Revenue revenue = new Revenue();
            revenue.setOrderDetailId(rs.getInt("OrderDetailId"));
            revenue.setDate(rs.getDate("date"));
            revenue.setProductId(rs.getInt("productId"));
            revenue.setProductName(rs.getString("productName"));
            revenue.setQuantity(rs.getInt("quantity"));
            revenue.setCost(rs.getDouble("cost"));
            list.add(revenue);
        }
        con.close();
        return list;
    }
    public ArrayList<Revenue> read5daysRevenue() throws SQLException {
    Date today = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(today);
    calendar.add(Calendar.DAY_OF_MONTH, -5);
    Date fiveDaysAgo = calendar.getTime();

    Connection con = DBContext.getConnection();
    ArrayList<Revenue> list = new ArrayList<>();
    PreparedStatement stm = con.prepareStatement("SELECT CONVERT(VARCHAR(10), CAST(OrderHeader.date AS DATE), 120) AS date, SUM(OrderDetail.price) AS total_revenue FROM OrderHeader INNER JOIN OrderDetail ON OrderHeader.orderHeaderId = OrderDetail.orderHeaderId WHERE OrderHeader.date >= ? GROUP BY CAST(OrderHeader.date AS DATE) ORDER BY CAST(OrderHeader.date AS DATE) DESC;");
    stm.setDate(1, new java.sql.Date(fiveDaysAgo.getTime()));
    ResultSet rs = stm.executeQuery();
    while (rs.next()) {
        Revenue revenue = new Revenue();
        revenue.setDate(rs.getDate("date"));
        revenue.setCost(rs.getDouble("total_revenue"));
        list.add(revenue);
    }
    con.close();
    return list;
}
     public Revenue readAllTimeRevenue() throws SQLException {
         Revenue rev=null;
    Connection con = DBContext.getConnection();
    PreparedStatement stm = con.prepareStatement("SELECT SUM(OrderDetail.price * OrderDetail.quantity) AS total_revenue FROM OrderHeader INNER JOIN OrderDetail ON OrderHeader.orderHeaderId = OrderDetail.orderHeaderId;");
    ResultSet rs = stm.executeQuery();
    while (rs.next()) {
        rev = new Revenue();
        rev.setCost(rs.getDouble("total_revenue"));
    }
    con.close();
    return rev;
}

}
