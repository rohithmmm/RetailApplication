package com.RetailApplication.RewardSystem.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

//Bulk financial transaction with amount and date
@Data
@AllArgsConstructor
public class BulkSubTransaction {
    private BigDecimal amount;
    private LocalDate transactionDate;
}
