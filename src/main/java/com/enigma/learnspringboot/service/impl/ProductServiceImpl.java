package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.repository.ProductRepository;
import com.enigma.learnspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;


@Service//daftar menjadikan bean service
public class ProductServiceImpl implements ProductService {

    @Autowired // carambil data setiap beans
    ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
//        return  productRepository.findById(id).get() ;
        return productRepository.findById(id).get();//product repository adalah datanya
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getProductPerPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


}
