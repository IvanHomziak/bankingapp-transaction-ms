package com.ihomziak.bankingapp.transactionms.dto;

import com.ihomziak.bankingapp.common.utils.TransactionStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TransactionEventResponseDTO {
    private String transactionUuid;
    private TransactionStatus transactionStatus;
    private String statusMessage;
}