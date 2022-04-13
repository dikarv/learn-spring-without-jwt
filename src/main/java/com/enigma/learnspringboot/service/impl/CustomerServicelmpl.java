package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.entity.Customer;
import com.enigma.learnspringboot.repository.CustomerRepository;
import com.enigma.learnspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicelmpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllProduct() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Page<Customer> getCustomerPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
        

    }
}
