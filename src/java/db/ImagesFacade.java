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
import java.util.ArrayList;
import java.util.List;
import models.Images;
import utils.DBContext;

/**
 *
 * @author Administrator
 */
public class ImagesFacade {
    public List<Images> select() throws SQLException {
        List<Images> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from images");
        list = new ArrayList<>();
        while (rs.next()) {
            Images images = new Images();
            images.setImgId(rs.getInt("imgId"));
            images.setProductId(rs.getInt("productId"));
            images.setImgSrc(rs.getString("imgSrc"));
            list.add(images);
        }
        con.close();
        return list;
    }
    public void uploadImage(Images images) throws SQLException{
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert images values(?,?)");
        stm.setInt(1,images.getProductId());
        stm.setString(2,images.getImgSrc());
        int count = stm.executeUpdate();
        con.close();  
    }
    public void updateImage(Images images) throws SQLException{
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update images set pId = ?, imgSrc = ?");
        stm.setInt(1,images.getProductId());
        stm.setString(2,images.getImgSrc());
        int count = stm.executeUpdate();
        con.close();
    }
    public Images read(int imgId) throws SQLException {
        Images images = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("SELECT * from images where imgId = ?");
        //Thực thi lệnh SELECT
        stm.setInt(1, imgId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong product
            images = new Images();
            images.setImgId(rs.getInt("imgId"));
            images.setProductId(rs.getInt("pId"));
            images.setImgSrc(rs.getString("imgSrc"));
        }
        con.close();
        return images;
    }
}
