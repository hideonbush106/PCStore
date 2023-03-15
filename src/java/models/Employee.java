/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Administrator
 */
public class Employee {

    private int employeeId;
    private String empName;
    private double salary;
    private String address;
    private String phoneNo;

    public Employee() {
    }

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(int employeeId, String empName, double salary, String address, String phoneNo) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.salary = salary;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Employee(String empName, double salary, String address, String phoneNo) {
        this.empName = empName;
        this.salary = salary;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Employee(int employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
