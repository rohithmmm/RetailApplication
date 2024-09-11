package com.RetailApplication.RewardSystem.Dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//encapsulate the response information related to customer rewards
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRewardResponse {
    private CustomerResponse customer;
    private int totalPoints;
    private List<RewardResponse> Rewards;
}
