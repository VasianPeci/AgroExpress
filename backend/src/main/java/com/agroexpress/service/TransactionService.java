package com.agroexpress.service;

import com.agroexpress.model.Order;
import com.agroexpress.model.Seller;
import com.agroexpress.model.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Order order);
    List<Transaction> getTransactionBySeller(Seller seller);
    List<Transaction>getAllTransactions();
}


