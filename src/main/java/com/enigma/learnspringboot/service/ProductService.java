package com.enigma.learnspringboot.service;

import com.enigma.learnspringboot.entity.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


//interface ini
public interface ProductService {
    public List<Product> getAllProduct();
    public Product getById(String id);
    public Product saveProduct(Product product);
    public void deleteProduct(String id);
    public Page<Product> getProductPerPage(Pageable pageable);
    public Product saveProductPicture(Product product, MultipartFile multipartFile);
}
