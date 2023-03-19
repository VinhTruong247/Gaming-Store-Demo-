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
public class Item {

    private Product product;
    private String username;

    public Item() {
    }

    public Item(Product product, String username) {
        this.product = product;
        this.username = username;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public double getCost() {
        return this.product.getPrice();
    }
}
