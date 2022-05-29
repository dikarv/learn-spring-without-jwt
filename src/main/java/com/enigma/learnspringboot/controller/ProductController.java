package com.enigma.learnspringboot.controller;

import com.enigma.learnspringboot.constant.ResponsMessage;
import com.enigma.learnspringboot.constant.apiURLConstant;
import com.enigma.learnspringboot.entity.Customer;
import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.service.ProductService;
import com.enigma.learnspringboot.utils.Respons;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(apiURLConstant.PRODUCT)
public class ProductController {
    //need service
    @Autowired
    ProductService productService;

//    @GetMapping("/products")
//    public List<Product> getAllProduct(){
//        return productService.getAllProduct();
//    }
    @GetMapping("/form/{id}")
    //nerima balikan dari servie
    public Product getId(@PathVariable String id){
        return productService.getById(id);
        //kirim ke service .impl
    }

    @PostMapping("/form")
    public Product createProduct(@RequestBody Product product){
        return  productService.saveProduct(product);

    }

//    @PostMapping("/products")
//    public ResponseEntity<Respons<Product>> createProduct(@RequestBody Product product){
//        Respons<Product> respons = new Respons<>();
//        String message = String.format(ResponsMessage.DATA_INSERTED,"product");
//        respons.setMessage(message);
//        respons.setData(productService.saveProduct(product));
//        return  ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(respons);
//        //repsons saat kita sukses menginputkan data
//
//    }

    @PutMapping("/form")
    public void updatePRoduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{id}")//mapping method alamat dan method yang digunakan oleh REST api d
    public void deleteProduct(@PathVariable String id){//memebuat method dimana parameter mengisi alamt yang ada
        productService.deleteProduct(id);//memanggil fungsi dari class repository
    }

    @GetMapping("/list")
    public Page<Product> getproductPerPage(@RequestParam(name = "page", defaultValue ="0") Integer page,
                                           @RequestParam(name = "size", defaultValue = "5")Integer sizePerPage,
                                           @RequestParam(name = "sortBy", defaultValue = "name")String sort,
                                           @RequestParam(name = "direction" ,defaultValue = "desc")String direction){
        Sort sort1 = Sort.by(Sort.Direction.fromString(direction),sort);
        Pageable pageable = PageRequest.of(page,sizePerPage, sort1);
        return productService.getProductPerPage(pageable);
    }


//    @PostMapping("/picture")
//    public void registerProductPicture(@RequestPart(name = "picture",required = false )MultipartFile file,
//                                       @RequestPart(name = "product") String product){
//        Product product1 = new Product();
//        try{
//            ObjectMapper objectMapper = new ObjectMapper();
//            product1 = objectMapper.readValue(product, Product.class);
//
//        }  catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        productService.saveProductPicture(product1, file);
//    }
}
