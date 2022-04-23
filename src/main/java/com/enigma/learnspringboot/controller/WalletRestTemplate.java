package com.enigma.learnspringboot.controller;

import com.enigma.learnspringboot.dto.WalletDto;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class WalletRestTemplate {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/opos")
    public ResponseEntity<WalletDto> createWallet (@RequestBody WalletDto walletDto){
        String url = "http://localhost:8070/wallets";
        ResponseEntity<WalletDto> response = restTemplate.postForEntity(URI.create(url),
                walletDto,
                WalletDto.class);
        return response;
    }
}
