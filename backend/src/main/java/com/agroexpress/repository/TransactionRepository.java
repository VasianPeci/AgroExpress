package com.agroexpress.repository;

import com.agroexpress.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findBySellerId(Long sellerId);
}


