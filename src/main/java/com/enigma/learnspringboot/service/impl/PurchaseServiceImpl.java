package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.constant.ResponsMessage;
import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.entity.Purchase;
import com.enigma.learnspringboot.entity.PurchaseDetail;
import com.enigma.learnspringboot.repository.PurchaseRepository;
import com.enigma.learnspringboot.service.ProductService;
import com.enigma.learnspringboot.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    PurchaseDetailServiceImpl purchaseDetail;
    @Autowired
    ProductService productService;

    @Override
    public void transaction(Purchase purchase) {
        Purchase purchase1 = purchaseRepository.save(purchase);
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
            if (product.getStock() > 0){
                productService.saveProduct(product);
                purchaseDetail.savePD(pd);
                purchaseRepository.save(purchase);
            }else{
                String.format(ResponsMessage.STOCK);
            }


        }
//        return purchaseRepository.save(purchase);

    }
}
