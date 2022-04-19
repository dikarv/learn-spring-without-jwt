package com.enigma.learnspringboot.controller;

import com.enigma.learnspringboot.entity.PurchaseDetail;
import com.enigma.learnspringboot.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseDetailController {
    @Autowired
    PurchaseDetailService purchaseDetailService;

    @PostMapping("/pd")
    public PurchaseDetail savePurchase(@RequestBody PurchaseDetail purchaseDetail){
       return purchaseDetailService.savePD(purchaseDetail);
    }

}
