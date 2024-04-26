package com.pluralsight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Products, Integer> cart = new HashMap<>();
    public void addToCart(List<Products> shoppingCart) {
        for(Products products : shoppingCart) {
            cart.computeIfPresent(products,(product, count)-> count + 1);
            cart.putIfAbsent(products, 1);
        }

    }

    public void displayCart() {
        for (Map.Entry<Products, Integer> item : cart.entrySet()) {
            Products products = item.getKey();
            Integer count = item.getValue();
            System.out.printf("%s     %d\n\n", products.getProductName(), count);
        }
    }

}
