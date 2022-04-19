package com.enigma.learnspringboot.controller;

import com.enigma.learnspringboot.constant.apiURLConstant;
import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;


@RestController
//@RequestMapping(apiURLConstant.PRODUCT)
public class ProductController {
    //need service
    @Autowired
    ProductService productService;

//    @GetMapping("/products")
//    public List<Product> getAllProduct(){
//        return productService.getAllProduct();
//    }
    @GetMapping("/products/{id}")
    //nerima balikan dari servie
    public Product getId(@PathVariable String id){
        return productService.getById(id);
        //kirim ke service .impl
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return  productService.saveProduct(product);

    }

    @PutMapping("/products/update")
    public void updatePRoduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @DeleteMapping("/products/delete")//mapping method alamat dan method yang digunakan oleh REST api d
    public void deleteProduct(@RequestParam String id){//memebuat method dimana parameter mengisi alamt yang ada
        productService.deleteProduct(id);//memanggil fungsi dari class repository
    }

    @GetMapping("/products")
    public Page<Product> getproductPerPage(@RequestParam(name = "page", defaultValue ="0") Integer page,
                                           @RequestParam(name = "size", defaultValue = "3")Integer sizePerPage,
                                           @RequestParam(name = "sortBy", defaultValue = "name")String sort,
                                           @RequestParam(name = "direction" ,defaultValue = "asc")String direction){
        Sort sort1 = Sort.by(Sort.Direction.fromString(direction),sort);
        Pageable pageable = PageRequest.of(page,sizePerPage, sort1);
        return productService.getProductPerPage(pageable);
    }

}
