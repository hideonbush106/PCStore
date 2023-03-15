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
public class Product {

    private int productId;
    private String productName;
    private double price;
    private String categoryName;
    private int categoryId;
    private String brandName;
    private int brandId;
    private String description;
    private String imgSrc;

    public Product() {
    }

    public Product(int productId, String productName, double price, int categoryId, int brandId, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.description = description;
    }

    public Product(String productName, double price, int categoryId, int brandId, String description) {
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    
    
    

}
