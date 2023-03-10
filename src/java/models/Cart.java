/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Cart {

    private Map<Integer, Item> map = null;

    public Cart() {
        map = new HashMap<>();
    }

    public void empty() {
        map.clear();
    }

    public Map<Integer, Item> getMap() {
        return map;
    }

    public Collection<Item> getItem() {
        return map.values();

    }

    public void setMap(Map<Integer, Item> map) {
        this.map = map;
    }

    public double getTotal() {
        double total = 0;
        for (Item item : map.values()) {
            total += item.getCost();
        }
        return total;
    }

    public void add(Item item) {
        int productId = item.getProduct().getProductId();
        if (map.containsKey(productId)) {
            Item oldItem = map.get(productId);
            oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
        } else {
            map.put(productId, item);
        }
    }

    public void remove(int productId) {
        map.remove(productId);
    }

    public void update(int productId, int quantity) {
        Item item = map.get(productId);
        item.setQuantity(quantity);
    }
}
