package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void subProduct(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                if( entry.getValue() > 1){
                    Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
                    Integer newQuantity = itemEntry.getValue() - 1;
                    products.replace(itemEntry.getKey(), newQuantity);break;
                }else if(entry.getValue()==1) {
                    products.remove(entry.getKey()) ;
                    break;
                }
            }
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Long countTotalPayment() {
        long payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (long) entry.getValue();
        }
        return payment;
    }
}
