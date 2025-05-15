package com.ihomziak.bankingapp.transactionms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ihomziak.bankingapp.transactionms.entity.Transaction;

@Repository
public interface CacheRepository extends CrudRepository<Transaction, String> {

    Transaction findTransactionByTransactionUuid(String transactionUuid);
}