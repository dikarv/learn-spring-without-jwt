package com.enigma.learnspringboot.controller;

import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.service.ProductService;
import com.enigma.learnspringboot.utils.Respons;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.file.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;



import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)//dari sisi view atau client
//jadi memakai notasi yang diatas
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {


    @MockBean
    ProductService productService;

    @InjectMocks
    ProductController productController;

    @Autowired
    MockMvc mockMvc;

    private Product product;

    @BeforeEach
    void setUp(){
        product =  new Product("01","shampoo",1000,3);

    }
    @AfterEach
    void cleanUp(){
        product = new Product();
    }

    @Test
    void getId() {
//        when(productService.getById(any(Product.class))).thenReturn(product);
    }

//    @Test
//    void createProduct() {//any dia bisa ngirim object dengan any
//        when(productService.saveProduct(any(Product.class))).thenReturn(new Product("01","shampoo",1000,3));
//        //diatas ceritanya di save nih
//
//
//       //disini data hasil save nya
//        ResponseEntity<Respons<Product>> product1 = productController.createProduct(product);
//        //certinta disni controller save lagi data nya
//
//        assertThat(product1.getBody().getData().getName()).isEqualTo("shampoo");
//        assertThat(product1.getId()).isEqualTo("01");
        //n
//    }
    //object mapper merubah object menjadi vaklue nya string
    // dengan mapping masih object dari json ke string
    //evertything in java object

    //kirim via postman berupa objek
    //terus bikin mapping dengan menggunakan mockmvc
    //sisi coede parsing dari object jadi string
    //mock mvc hit mvc
    @Test
    void createproductWithResponseHeader() throws Exception {
        given(productService.saveProduct(any(Product.class))).willAnswer(invocationOnMock -> {
            System.out.println("Invoke" + invocationOnMock);
            return invocationOnMock.getArgument(0);
        });

        product =  new Product("01","shampoo",1000,3);
        this.mockMvc.perform(post("/products").
                contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(product)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("name", Matchers.is(product.getName())));//https statsu 201

    }

    @Test
    void createProductWithHeaderStatus400() throws Exception{
        this.mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
    }


    public static String asJsonString(Object obj){
        try {
            return  new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw  new RuntimeException(e);
        }
    }

    @Test
    void updatePRoduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getproductPerPage() {
    }
}