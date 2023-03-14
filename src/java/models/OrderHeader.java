/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class OrderHeader {

    private int orderHeaderId;
    private Date date;
    private boolean status;
    private int customerId;
    private String customerName;
    private int employeeId;
    private String employeeName;

    public OrderHeader() {
    }

    public OrderHeader(boolean status) {
        this.status = status;
    }

    public OrderHeader(int orderHeaderId, Date date, boolean status, int customerId, String customerName, int employeeId, String employeeName) {
        this.orderHeaderId = orderHeaderId;
        this.date = date;
        this.status = status;
        this.customerId = customerId;
        this.customerName = customerName;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public OrderHeader(int orderHeaderId, Date date, boolean status, String customerName) {
        this.orderHeaderId = orderHeaderId;
        this.date = date;
        this.status = status;
        this.customerName = customerName;
    }

    public int getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(int orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}
