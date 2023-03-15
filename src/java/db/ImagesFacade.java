/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
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
}
