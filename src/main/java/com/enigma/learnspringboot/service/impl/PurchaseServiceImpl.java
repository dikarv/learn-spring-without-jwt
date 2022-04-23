package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.constant.apiURLConstant;
import com.enigma.learnspringboot.entity.Customer;
import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.entity.Purchase;
import com.enigma.learnspringboot.entity.PurchaseDetail;
import com.enigma.learnspringboot.repository.PurchaseRepository;
import com.enigma.learnspringboot.service.ProductService;
import com.enigma.learnspringboot.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    PurchaseDetailServiceImpl purchaseDetail;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerServicelmpl customerServicelmpl;
    @Autowired
    RestTemplate restTemplate;


    @Override
    @Transactional
    public void transaction(Purchase purchase) {
        Purchase purchase1 = purchaseRepository.save(purchase);
        BigDecimal amount = new BigDecimal(0.0);
        for (PurchaseDetail pd : purchase.getPurchaseDetails()){//purchase detail array liist di entity purchase ambil dari parmeter yang depan postman
            pd.setPurchase(purchase1);
            purchaseDetail.savePD(pd);
            Product product = productService.getById(pd.getProduct().getId());//mengisi column product id dan mengambil product seusai id
//            System.out.println(product);
            Double price = Double.valueOf(product.getProductPrice());
            pd.setPricesell(price);
            Integer quantity = pd.getQuantity();
            Integer stock = product.getStock();

            product.setStock(stock-quantity);
            Double total = price*quantity;
            System.out.println("Ini loh" + total);
            pd.setPricesell(total);

            Double grandTotal =+ total;
            System.out.println("INI GRANDTOTAL" + grandTotal);



            if (product.getStock() > 0){
                productService.saveProduct(product);
                purchaseDetail.savePD(pd);

            }


        }
        Customer customer = customerServicelmpl.getById(purchase.getCustomer().getId());
        String url = apiURLConstant.OPO_URL + "/debit";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("phoneNumber", customer.getPhoneNumber())
                                .queryParam("amount", amount);
        restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null,String.class);
        purchaseRepository.save(purchase);
//        return purchaseRepository.save(purchase);

    }
    //===========================================REST TEMPLATE==================================================



}
