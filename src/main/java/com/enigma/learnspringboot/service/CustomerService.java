package com.enigma.learnspringboot.service;

import com.enigma.learnspringboot.entity.Customer;
import com.enigma.learnspringboot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllProduct();
    public Customer getById(Integer id);
    public Customer saveCustomer(Customer customer);
    public void deleteCustomer(Integer id);
    public Page<Customer> getCustomerPage(Pageable pageable);
}
