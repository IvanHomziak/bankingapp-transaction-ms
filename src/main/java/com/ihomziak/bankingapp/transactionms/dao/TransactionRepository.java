package com.ihomziak.bankingapp.transactionms.dao;

import com.ihomziak.bankingapp.common.utils.TransactionStatus;
import com.ihomziak.bankingapp.transactionms.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.LockModeType;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Базовий пошук транзакції за UUID
    Optional<Transaction> findTransactionByTransactionUuid(String transactionUuid);

    // Пошук транзакцій за статусом
    Optional<List<Transaction>> findTransactionByTransactionStatus(TransactionStatus transactionStatus);

    // Метод із песимістичним блокуванням для критичних операцій
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT t FROM Transaction t WHERE t.transactionUuid = :uuid")
    Optional<Transaction> findTransactionByUuidForUpdate(@Param("uuid") String uuid);

//    // Пакетне оновлення статусів транзакцій
//    @Modifying
//    @Query("UPDATE Transaction t SET t.transactionStatus = :status WHERE t.transactionUuid IN :uuids")
//    void updateTransactionStatusByUuids(@Param("status") TransactionStatus status, @Param("uuids") List<String> uuids);

//    // Додатковий метод для пошуку транзакцій за ідентифікатором рахунку
//    Optional<List<Transaction>> findTransactionsByAccountId(String accountId);
}