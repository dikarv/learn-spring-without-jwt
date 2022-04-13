package com.enigma.learnspringboot.repository;

import com.enigma.learnspringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
