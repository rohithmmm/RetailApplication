package com.RetailApplication.RewardSystem.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne private Customer customer;
  private BigDecimal amount;
  private LocalDateTime transactionDate;
}
