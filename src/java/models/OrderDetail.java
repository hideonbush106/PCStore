/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Administrator
 */
public class OrderDetail {
    private int id;
    private int orderHeaderId;
    private int quantity;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(int id, int orderHeaderId, int quantity, double price) {
        this.id = id;
        this.orderHeaderId = orderHeaderId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(int orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
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
