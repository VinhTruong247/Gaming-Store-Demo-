/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author VU HONG ANH
 */
public class Cart {
    private Map<Product, Integer> map = null;
    
    public Cart(){
        map = new HashMap<>();
    }
    
    public void add(Product product){
        int quantity = map.get(product);
        if(map.containsKey(product)){
            quantity++;
        } else {
            map.put(product, quantity);
        }
    }
    
    public void update(Product product, int quantity){
        map.put(product, quantity);
    }
    
    public void remove(Product product){
        map.remove(product);
    }
    
    public void empty(){
        map.clear();
    }
    
    public Map<Product, Integer> getMap(){
        return map;
    }
    
    public Collection<Product> getItem(){
        return map.keySet();
    }
    
    public double getTotal(){
        double total = 0;
        for (Product product : map.keySet()) {
            total += product.getPrice()*map.get(product);
        }
        return total;
    }
    
}
