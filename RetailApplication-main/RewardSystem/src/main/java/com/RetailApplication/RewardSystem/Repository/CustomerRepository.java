package com.RetailApplication.RewardSystem.Repository;


import com.RetailApplication.RewardSystem.Entity.Customer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
