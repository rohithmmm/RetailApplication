package com.RetailApplication.RewardSystem.Dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

//transaction request with customer ID and amount
@Data
public class TransactionRequest {
    private UUID customerId;
    private BigDecimal amount;
}
