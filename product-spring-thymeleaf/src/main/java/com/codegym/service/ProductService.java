package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    private static Map<Integer,Product> products ;

    static {
        products = new HashMap<>() ;
        products.put(1, new Product(1, "Black Coffee", 10000, 100,"Ca ph den"));
        products.put(2, new Product(2, "Black And Milk Coffee", 12000, 100,"Ca ph sua"));
        products.put(3, new Product(3,"Sai Gon Black Coffee", 15000, 100,"Ca ph den"));
        products.put(4, new Product(4, "Red Bull", 15000, 100,"Ca ph den"));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id) ;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listProducts = new ArrayList<>(products.values());
        List<Product> listSearchName = new ArrayList<>() ;
        name = name.toLowerCase();
        for(Product p : listProducts){
            if(p.getName().toLowerCase().contains(name)){
                listSearchName.add(p);
            }
        }
        return listSearchName ;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id) ;
    }
}
