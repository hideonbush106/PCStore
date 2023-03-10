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
public class Customer {

    private int customerId;
    private String fullName;
    private String address;
    private String phoneNo;

    public Customer() {
    }

    public Customer(String fullName, String address, String phoneNo) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Customer(int customerId, String fullName, String address, String phoneNo) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
