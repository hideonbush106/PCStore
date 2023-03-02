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
public class Customer {
    private int id;
    private String CustomerName;
    private String Address;
    private String PhoneNo;

    public Customer() {
    }

    public Customer(int id, String CustomerName, String Address, String PhoneNo) {
        this.id = id;
        this.CustomerName = CustomerName;
        this.Address = Address;
        this.PhoneNo = PhoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }
    
}
