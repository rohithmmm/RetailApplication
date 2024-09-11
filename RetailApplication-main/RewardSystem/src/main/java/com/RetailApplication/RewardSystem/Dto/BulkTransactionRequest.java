package com.RetailApplication.RewardSystem.Dto;

import java.util.List;
import java.util.UUID;
import lombok.Data;

//request to process bulk transactions for a customer with UUID
@Data
public class BulkTransactionRequest {
    private UUID customerId;
    private List<BulkSubTransaction> transactions;
}
