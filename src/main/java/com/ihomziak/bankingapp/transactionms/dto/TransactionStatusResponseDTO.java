package com.ihomziak.bankingapp.transactionms.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionStatusResponseDTO {
    private String transactionUuid;
    private LocalDateTime startTransactionTime;
}