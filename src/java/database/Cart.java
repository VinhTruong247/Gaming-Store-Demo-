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
    private Map<Integer, Item> map = null;
    
    public Cart(){
        map = new HashMap<>();
    }
    
    public void add(Item item){
        int productId = Integer.parseInt(item.getProduct().getProductId());
        if(map.containsKey(productId)){
            Item oldItem = map.get(productId);
            oldItem.setAddQuantity(oldItem.getAddQuantity() + item.getAddQuantity());
        } else {
            map.put(productId, item);
        }
    }
    
    public void update(String productId, int quantity){
        Item item = map.get(Integer.parseInt(productId));
        item.setAddQuantity(quantity);
    }
    
    public void remove(String productId){
        map.remove(Integer.parseInt(productId));
    }
    
    public void empty(){
        map.clear();
    }
    
    public Map<Integer, Item> getMap(){
        return map;
    }
    
    public Collection<Item> getItem(){
        return map.values();
    }
    
    public double getTotal(){
        double total = 0;
        for (Item item : map.values()) {
            total += item.getCost();
        }
        return total;
    }
    
}
