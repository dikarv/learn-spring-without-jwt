package com.enigma.learnspringboot.repository;

import com.enigma.learnspringboot.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor {
//    Page<Customer> findAll(Specification<Customer> customerSpecification, Pageable pageable);
    //memetakan parameter agar dapat mencari lebih dari 1

    public List<Customer> findCustomerByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase
    (@Param("firstname") String firstname, @Param("lastname")  String lastname);

    //setting repository JPA daman dia menggunakan fungsi mencari nama menggunakan parameter dengan 2 paramere


}
