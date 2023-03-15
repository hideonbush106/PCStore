/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Employee;

/**
 *
 * @author Administrator
 */
public class EmployeeFacade {

    public List<Employee> select() throws SQLException {
        List<Employee> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from employee");
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeId"));
            employee.setEmpName(rs.getString("empName"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setAddress(rs.getString("address"));
            employee.setPhoneNo(rs.getString("phoneNo"));
            list.add(employee);
        }
        con.close();
        return list;
    }

    public void create(Employee employee) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("INSERT Employee ([EmployeeId], [EmpName], [salary], [Address],[PhoneNo]) VALUES (?,?,?,?,?)");
        //Thực thi lệnh
        stm.setInt(1, employee.getEmployeeId());
        stm.setString(2, employee.getEmpName());
        stm.setDouble(3, employee.getSalary());
        stm.setString(4, employee.getAddress());
        stm.setString(5, employee.getPhoneNo());
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public Employee read(int employeeId) throws SQLException {
        Employee employee = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("select * from employee where employeeId = ?");
        //Thực thi lệnh SELECT
        stm.setInt(1, employeeId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong product
            employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeId"));
            employee.setEmpName(rs.getString("empName"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setAddress(rs.getString("address"));
            employee.setPhoneNo(rs.getString("phoneNo"));
        }
        con.close();
        return employee;
    }

    public void delete(int employeeId) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("delete from employee where employeeId = ?");
        //Thực thi lệnh 
        stm.setInt(1, employeeId);
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public void update(Employee employee) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update employee set salary= ? where employeeId = ?");
        //Thực thi lệnh 
        stm.setDouble(1, employee.getSalary());
        stm.setInt(2, employee.getEmployeeId());
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }
}
