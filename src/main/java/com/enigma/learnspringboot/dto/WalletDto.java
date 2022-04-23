package com.enigma.learnspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter

public class WalletDto {
    private String id;
    private String phoneNumber;
    private BigDecimal balance;

    public WalletDto(String phoneNumber, BigDecimal balance) {
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
}
