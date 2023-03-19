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
        PreparedStatement stm = con.prepareStatement("SELECT OrderDetailId, date, OrderDetail.ProductId as productId, productName, quantity, OrderDetail.price as cost from OrderHeader inner join OrderDetail on OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId inner join Product on OrderDetail.productId = Product.productid");
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

//    public double getTotalCost(Date date) throws SQLException {
//        double totalCost = 0;
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("select sum(OrderDetail.price) as totalcost from OrderHeader inner join OrderDetail on OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId inner join Product on OrderDetail.productId = Product.productid where date = ? ");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        stm.setString(1, sdf.format(date));
//        ResultSet rs = stm.executeQuery();
//        totalCost = rs.getDouble("sum");
//        return totalCost;
//    }
    public List<Revenue> readBetweenDate(Date dateFrom, Date dateTo) throws SQLException {
        Connection con = DBContext.getConnection();
        List<Revenue> list = new ArrayList<>();
        PreparedStatement stm = con.prepareStatement("SELECT OrderDetailId, date, OrderDetail.ProductId as productId, productName, quantity, OrderDetail.price as cost from OrderHeader inner join OrderDetail on OrderHeader.OrderHeaderId = OrderDetail.OrderHeaderId inner join Product on OrderDetail.productId = Product.productid WHERE date BETWEEN ? AND ?");
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
}
