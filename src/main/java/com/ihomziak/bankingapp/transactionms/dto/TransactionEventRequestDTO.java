package com.ihomziak.bankingapp.transactionms.dto;

import com.ihomziak.bankingapp.common.utils.TransactionStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEventRequestDTO {
    private String transactionUuid;
    private String senderUuid;
    private String receiverUuid;
    private Double amount;
    private TransactionStatus transactionStatus;
}