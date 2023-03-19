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
    private int addQuantity;

    public Item() {
    }

    public Item(Product product, int addQuantity) {
        this.product = product;
        this.addQuantity = addQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAddQuantity() {
        return addQuantity;
    }

    public void setAddQuantity(int addQuantity) {
        this.addQuantity = addQuantity;
    }

    public double getCost() {
        return this.product.getPrice() * this.addQuantity;
    }
}
