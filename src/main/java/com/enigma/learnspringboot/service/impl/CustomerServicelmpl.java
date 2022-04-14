package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.dto.CustomersSearchDTO;
import com.enigma.learnspringboot.entity.Customer;
import com.enigma.learnspringboot.repository.CustomerRepository;
import com.enigma.learnspringboot.service.CustomerService;
import com.enigma.learnspringboot.spesification.CustomerSpesification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
        return customerRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(String.valueOf(id));
    }

    @Override
    public Page<Customer> getCustomerPage(CustomersSearchDTO customersSearchDTO, Pageable pageable) {
        Specification<Customer> customerSpecification = CustomerSpesification.getSpesification
                (customersSearchDTO);
        return customerRepository.findAll(customerSpecification, pageable);
    }

    @Override
    public List<Customer> getCustomerByName(String firstname, String lastname) {
        return customerRepository.
                findCustomerByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase
                (firstname, lastname);
    }
}
