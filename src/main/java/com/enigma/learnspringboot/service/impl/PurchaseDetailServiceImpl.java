package com.enigma.learnspringboot.service.impl;


import com.enigma.learnspringboot.entity.PurchaseDetail;
import com.enigma.learnspringboot.repository.PurchaseDetailRepository;
import com.enigma.learnspringboot.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

    @Autowired
    PurchaseDetailRepository purchaseDetailRepository;

    @Override
    public PurchaseDetail savePD(PurchaseDetail pd) {

        return purchaseDetailRepository.save(pd);
    }
}
