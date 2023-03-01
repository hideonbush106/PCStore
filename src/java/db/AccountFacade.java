/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Account;
import utils.Hasher;

/**
 *
 * @author PHT
 */
public class AccountFacade {

    public Account login(String email, String password) throws SQLException, NoSuchAlgorithmException {
        Account account = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select * from account where email=? and password=?");
        //Thực thi lệnh SELECT
        stm.setString(1, email);
        stm.setString(2, Hasher.hash(password));
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            account = new Account();
            account.setId(rs.getInt("id"));
            account.setEmail(rs.getString("email"));
            account.setPassword(rs.getString("password"));
            account.setUsername(rs.getString("username"));
            account.setRole(rs.getString("role"));
        }
        con.close();
        return account;
    }
}
