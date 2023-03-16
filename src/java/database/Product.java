/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author VU HONG ANH
 */
public class Product {

    private String productId;
    private String productName;
    private String productPublisher;
    private String category;
    private String description;
    private double quantity;
    private double price;
    private String productImages;

    public Product() {

    }

    public Product(String productId, String productName, String productPublisher, String category, String description, double quantity, double price, String productImages) {
        this.productId = productId;
        this.productName = productName;
        this.productPublisher = productPublisher;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.productImages = productImages;
    }
  

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPublisher() {
        return productPublisher;
    }

    public void setProductPublisher(String productPublisher) {
        this.productPublisher = productPublisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
   
}
