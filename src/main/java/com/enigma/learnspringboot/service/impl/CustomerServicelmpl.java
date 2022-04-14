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
    public Customer getById(String id) {
        return customerRepository.findById(Integer.valueOf(id)).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public Page<Customer> getCustomerPage(Pageable pageable) {
        return null;
    }

    @Override
    public List<Customer> getCustomerByName(String firstname) {
        return customerRepository.findCustomerByFirstnameContains(firstname);
    }
}
