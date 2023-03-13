/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DBContext;

/**
 *
 * @author Admin
 */
public class CartFacade {

    public void checkout() throws SQLException {
        Connection con = DBContext.getConnection();
        con.setAutoCommit(false);
        try {
            PreparedStatement stm = con.prepareStatement("");
            //Process lenh SQL
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        } finally {
            con.close();
        }
    }
}
