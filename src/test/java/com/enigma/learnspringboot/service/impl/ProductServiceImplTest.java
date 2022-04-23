package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.exception.DataNotFoundException;
import com.enigma.learnspringboot.repository.ProductRepository;
import com.enigma.learnspringboot.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
public class ProductServiceImplTest {//product service impl dapat menggunakan extemsion dari mockito.class

    //test tiap method

    @Mock//new
    ProductRepository productRepository;
    //membuat dummy repository

    @InjectMocks//new
    ProductServiceImpl productServiceImpl;
    //memasaukan nilai pada productErvice yang pada akhirnya akan do eksekusi
        @BeforeEach//ngisi data
        void setup (){
//            Product product =  new Product("01", "Coklat", 2000, 10);
//            biar ga ngulang ngulang ngisi
        }
        @AfterEach//supaya tidak terjadi memory leak
        void cleanUp(){
//            product = new Product();
        }

    //===Positif test case
    @Test
    void getAllProduct() {
        //retunr nya dlu baru hit repository dan kemudia hit service kemudian
        //bikin perbanding an assert / verify agar dapat
        List<Product> productsArr = new ArrayList<>();
        Product products1 = new Product("01", "Coklat", 2000, 10);
        Product products2 = new Product("02", "keju", 2000, 10);
        productsArr.add(products1);
        productsArr.add(products2);
        //=======================================================
        //membuat data product yang akan di panggil dengan menambahkan array list
        //simulasi repo meng hit database dean mengembalikan nilai dari Listproduct
        //List productList menampung list product arr dengan
        //memerintahkan service untuk memanggil method get all product
        //asssert equals mebandingkan nilai data product dengan productlist.size
        //dan verisfikasi apakah method findall memanggil repository sebanyak sekali
        //=======================================================
        when(productRepository.findAll()).thenReturn(productsArr);
        List<Product> productsList =productServiceImpl.getAllProduct();
        assertEquals(2,productsList.size());
        verify(productRepository, times(1)).findAll();
    }
///negatif  test case
//    @Test
//    void getProductByIdNotPresent(){
//        Throwable ex = assertThrows(DataNotFoundException.class,() -> productServiceImpl.getById("p01"));
//        System.out.println(ex.getMessage());
//
//    }


    @Test
    void getById() {
        when(productRepository.findById("01")).
                thenReturn(Optional.of(new Product
                        ("01", "Coklat", 2000, 10)));
        Product product = productServiceImpl.getById("01");
        assertEquals("01",product.getId());
        assertEquals("Coklat", product.getName());
        assertEquals(2000,product.getProductPrice());
        assertEquals(10,product.getStock());
        assertNotEquals("02",product.getId());
    }

    @Test
    void saveProduct() {
        //product pada parameter service
        Product product = new Product("s12", "Shampoo", 1000, 10);
        productServiceImpl.saveProduct(product);
        verify(productRepository, times(1)).save(product);
//        verify(productService, times(1)).saveProduct(product);
    }
    @Test
    void saveProductSuccesValue(){
        when(productRepository.save(new Product
                ("s12", "Ikannn", 1000, 10)))
                .thenReturn(new Product
                        ("s12", "Ikannn", 1000, 10));
        Product dummy = new Product("s12", "Ikannn", 1000, 10);
        Product test1 = productServiceImpl.saveProduct(dummy);
        assertEquals("Ikannn",test1.getName());
    }

    @Test
    void deleteProduct() {
//        Product product =  new Product
//                ("01", "Coklat", 2000, 10);
//        List<Product> arr = new ArrayList<>();
//                arr.add(product);
        productServiceImpl.deleteProduct("01");
//        assertEquals(0, productServiceImpl.getAllProduct().size());
        verify(productRepository, times(1)).deleteById("01");
        //benarkan bila productSrviceImpl. mendelete dengan paramater id 01 si repostirory nya kepanggil sekali

    }

    @Test
    void getProductPerPage() {
        Pageable pageable = PageRequest.of(1,2, Sort.by("id"));
        Page<Product> page=productServiceImpl.getProductPerPage(pageable);
        when(productRepository.findAll(pageable)).thenReturn(page);
        assertEquals(productRepository.findAll(pageable), page);

    }
}