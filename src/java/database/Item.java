/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;

/**
 *
 * @author VU HONG ANH
 */
public class Item {

    private String productId;
    private int quantity;

    public Item(){
    }
    
    public Item(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }   
    
    public double getTotal() throws SQLException {
        ProductFacade pf = new ProductFacade();
        return quantity*pf.read(productId).getPrice();
    }
}
