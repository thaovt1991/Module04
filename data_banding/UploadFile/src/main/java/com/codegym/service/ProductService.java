package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ProductService implements IProductService {
    private static List<Product> products ;

    static {
        products = new ArrayList<>() ;
        products.add(new Product(1, "Black Coffee", "Ca phe den","cfden_nong.jpg"));
        products.add(new Product(2, "Black And Milk Coffee", "Ca phe sua","cfsua-nong.jpg"));
        products.add(new Product(3,"Caramel-Macchiato","Sua + ca phe + da nhieu","caramel-macchiato.jpg"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p = product;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }

}
