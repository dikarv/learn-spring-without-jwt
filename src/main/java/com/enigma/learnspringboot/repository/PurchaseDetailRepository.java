package com.enigma.learnspringboot.repository;

import com.enigma.learnspringboot.entity.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail ,String> {
}
