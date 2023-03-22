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

    static Map<String, Item> map = null;

    public Cart() {
        map = new HashMap<>();
    }

    public void add(Product product, int newQuantity) {
        String productId = product.getProductId();
        if(map == null) System.out.println("e");
        if (map.containsKey(productId)) {
            int quantity = map.get(productId).getQuantity();
            newQuantity+=quantity;
        }
        Item item = new Item(product, newQuantity);
        map.put(productId, item);
    }

    public void update(Product product, int quantity) {
        String productId = product.getProductId();
        Item item = new Item(product, quantity);
        map.put(productId, item);
    }

    public void remove(Product product) {
        String productId = product.getProductId();
        map.remove(productId);
    }

    public void empty() {
        map.clear();
    }

    public int getQuantity(String productId) {
        return map.get(productId).getQuantity();
    }

    public Collection<Item> getItem() {
        return map.values();
    }

    public double getTotal() {
        double total = 0;
        for (Item item : map.values()) {
            total += item.getTotal();
        }
        return total;
    }
    
    public int getCount() {
        int count = 0;
        for(Item item : getItem()) count++;
        return count;
    }
    @Override
    public String toString(){
        String str = "";
        for (Item item : map.values()) {
            String p = item.getProduct().getProductId()+"-"+item.getQuantity();
            if(str.isEmpty()) str += p;
            else str += ","+p;
        }
        return str;
    }
}
