package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.repository.ProductRepository;
import com.enigma.learnspringboot.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public Product getById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);

    }

    @Override
    public Page<Product> getProductPerPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product saveProductPicture(Product product, MultipartFile file ) {
        String pathFolderString = "C:\\Dev\\Spring\\learn-Springboot\\src\\main\\java\\com\\enigma\\learnspringboot\\asset\\";
        Path pathFolder = Paths.get(pathFolderString + file.getOriginalFilename());
        Path pathFile = Paths.get(pathFolder.toString() + "/" + file.getOriginalFilename());

        try{
            Files.createDirectories(pathFolder);
            file.transferTo(pathFile);
        }catch (IOException e){
            e.printStackTrace();
        }

        product.setProductPicture(file.getOriginalFilename());
        return productRepository.save(product);
    }
}
