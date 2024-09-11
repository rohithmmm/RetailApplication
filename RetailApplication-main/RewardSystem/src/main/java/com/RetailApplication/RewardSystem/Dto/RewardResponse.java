package com.RetailApplication.RewardSystem.Dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

//response payload of an API endpoint to provide detailed information about a reward transaction
@Data
public class RewardResponse {
    private UUID transactionId;
    private BigDecimal transactionAmount;
    private int points;
    private LocalDateTime awardedDate;
}
