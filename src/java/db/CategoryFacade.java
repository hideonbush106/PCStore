/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import utils.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Brand;
import models.Category;

/**
 *
 * @author Admin
 */
public class CategoryFacade {

    public List<Category> select() throws SQLException {
        List<Category> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();

        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from category");
        list = new ArrayList<>();
        while (rs.next()) {
            //doc mau tin hien hanh de vao doi tuong toy
            Category category = new Category();
            category.setCategoryId(rs.getInt("categoryId"));
            category.setName(rs.getString("name"));
            list.add(category);
        }
        con.close();
        return list;
    }
}
