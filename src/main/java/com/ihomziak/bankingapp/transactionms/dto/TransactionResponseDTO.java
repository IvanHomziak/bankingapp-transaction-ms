package com.ihomziak.bankingapp.transactionms.dto;

import com.ihomziak.bankingapp.common.utils.TransactionStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDTO {
    private String transactionUuid;
    private TransactionStatus transactionStatus;
    private String errorMessage;
    private Double updatedSenderBalance;
    private Double updatedReceiverBalance;

    /**
     * String transactionUuid;
     * TimeDate startTransactionTime;
     * TimeDate finishedTransactionTime;
     * Enum
     */
}
