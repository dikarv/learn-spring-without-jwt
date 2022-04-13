package com.enigma.learnspringboot.service;

import com.enigma.learnspringboot.entity.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;


//interface ini
public interface ProductService {
    public List<Product> getAllProduct();
    public Product getById(Integer id);
    public Product saveProduct(Product product);
    public void deleteProduct(Integer id);
    public Page<Product> getProductPerPage(Pageable pageable);
}
