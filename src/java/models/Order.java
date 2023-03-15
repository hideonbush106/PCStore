/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {

    private int orderHeaderId;
    private Date date;
    private String fullname;
    private String productName;
    private int quantity;
    private double price;
    private boolean status;

    public Order() {
    }

    public Order(int orderHeaderId, Date date, boolean status, String fullname, String productName, int quantity, double price) {
        this.orderHeaderId = orderHeaderId;
        this.date = date;
        this.status = status;
        this.fullname = fullname;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderHeaderId() {
        return orderHeaderId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
