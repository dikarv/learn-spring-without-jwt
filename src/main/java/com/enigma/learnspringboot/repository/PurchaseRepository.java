package com.enigma.learnspringboot.repository;

import com.enigma.learnspringboot.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, String > {
}
