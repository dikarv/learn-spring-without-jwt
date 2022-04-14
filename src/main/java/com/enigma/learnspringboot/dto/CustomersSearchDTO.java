package com.enigma.learnspringboot.dto;

//data transfer object

import com.fasterxml.jackson.databind.DatabindException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter@Setter
public class CustomersSearchDTO {
    //memanipulasi data objek yang di buat
    //data transfer Objek dta dijadikan objeck

    private String searchCustomerFirstName;
    private String getSearchCustomerLastName;
    private Date searchCustomerDateOfBirth;

    //membuat varibale penampung
}
