package com.RetailApplication.RewardSystem.Controller;

import com.RetailApplication.RewardSystem.Dto.BulkTransactionRequest;
import com.RetailApplication.RewardSystem.Dto.CustomerRewardResponse;
import com.RetailApplication.RewardSystem.Dto.TransactionRequest;
import com.RetailApplication.RewardSystem.Exception.RewardServiceException;
import com.RetailApplication.RewardSystem.Service.RewardService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
  @Autowired private RewardService rewardService;

  /**
   * Get rewards for a customer
   * @param customerId
   * @param months
   * @return Customer Rewards
   */
  @GetMapping("reward/customer/{customerId}")
  public ResponseEntity<CustomerRewardResponse> getCustomerRewards(
      @PathVariable UUID customerId,
      @RequestParam(value = "months", defaultValue = "3") int months) {
    if (months < 1 || months > 12) {
      throw new RewardServiceException("Invalid months. Months must be between 1 and 12.");
    }
    CustomerRewardResponse response = rewardService.getCustomerRewards(customerId, months);
    return ResponseEntity.ok(response);
  }

  /**
   * Get rewards for all customers
   * @param months
   * @return Customer Reward List
   */
  @GetMapping("reward")
  public ResponseEntity<List<CustomerRewardResponse>> getRewardsAllCustomers(@RequestParam(value = "months", defaultValue = "3") int months){
    if (months < 1 || months > 12) {
      throw new RewardServiceException("Invalid months. Months must be between 1 and 12.");
    }
    return ResponseEntity.ok(rewardService.getAllCustomerRewards(months));
  }

  /**
   * Process a single transaction
   * @param transactionRequest
   * @return Transaction status
   */
  @PostMapping("transaction/createTransaction")
  public ResponseEntity<String> handleTransaction(
      @RequestBody TransactionRequest transactionRequest) {
    if (transactionRequest == null
        || transactionRequest.getAmount() == null
        || transactionRequest.getCustomerId() == null) {
      throw new RewardServiceException("Invalid transaction Request");
    }

    rewardService.handleTransaction(
        transactionRequest.getCustomerId(), transactionRequest.getAmount(), LocalDateTime.now());
    return ResponseEntity.ok("Transaction processed and rewards awarded");
  }

  /**
   * Process bulk transactions for a customer
   * @param bulkTransactionRequest
   * @return bulk Transaction details
   */
  @PostMapping("transaction/createBulkTransaction")
  public ResponseEntity<BulkTransactionRequest> handleBulkTransaction(
      @RequestBody BulkTransactionRequest bulkTransactionRequest) {
    if (bulkTransactionRequest.getCustomerId() == null
        || bulkTransactionRequest.getTransactions().isEmpty()) {
      throw new RewardServiceException("Invalid transaction Request");
    }
    return ResponseEntity.ok(
        rewardService.handleBulkTransactions(
            bulkTransactionRequest.getCustomerId(), bulkTransactionRequest.getTransactions()));
  }


}
