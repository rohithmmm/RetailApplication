package com.RetailApplication.RewardSystem.Dto;

import java.util.UUID;
import lombok.Data;

//class written to be used for sending customer details as a response
@Data
public class CustomerResponse {
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
}
