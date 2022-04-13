package com.enigma.learnspringboot.repository;

import com.enigma.learnspringboot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Entity maping ke class PRoduct, Type data Integer karena id pada class Product Integer
    //JPA repositori membungkus hibernate menjadi fungsi gungsi yang akan digunakan jadi tidak perlu ada DAO
    //
    Page<Product> findAll(Pageable pageable);

}
