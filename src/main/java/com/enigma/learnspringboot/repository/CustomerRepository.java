package com.enigma.learnspringboot.repository;

import com.enigma.learnspringboot.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);
    //memetakan parameter agar dapat mencari lebih dari 1
    public List<Customer> findCustomerByFirstnameContains(@Param("firstname") String firstname);
    //setting repository JPA daman dia menggunakan fungsi mencari nama menggunakan parameter dengan 2 paramere


}
