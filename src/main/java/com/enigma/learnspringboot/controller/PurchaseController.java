package com.enigma.learnspringboot.controller;


import com.enigma.learnspringboot.entity.Purchase;
import com.enigma.learnspringboot.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/transaction")
    public void transaction(@RequestBody Purchase purchase){
    purchaseService.transaction(purchase);
    }
}

//    @PostMapping("/transaction")
//    Purchase savePurchase(@RequestBody Purchase purchase){
//
////        return purchaseService.transaction(purchase);
//    }
//}
