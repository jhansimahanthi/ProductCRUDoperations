package com.codegnan.dao;


import java.util.List;
import com.codegnan.model.Product;

public interface ProductDao {

    void addProduct(Product product);     

    Product getProductById(int id);      
    List<Product> getAllProducts();       

    void deleteProduct(int id);           
}





