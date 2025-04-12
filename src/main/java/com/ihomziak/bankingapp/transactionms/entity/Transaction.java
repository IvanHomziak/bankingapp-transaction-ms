package com.ihomziak.bankingapp.transactionms.entity;

import com.ihomziak.bankingapp.common.utils.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long transactionId;

    @Column(name = "transaction_uuid")
    private String transactionUuid;

    @Column(name = "sender_uuid")
    private String senderUuid;

    @Column(name = "receiver_uuid")
    private String receiverUuid;

    @Column(name = "amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status")
    private TransactionStatus transactionStatus;

    @CreatedDate
    @Column(name = "transaction_date", updatable = false)
    private LocalDateTime transactionDate;

    @LastModifiedDate
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Version
    private Long version;
}
