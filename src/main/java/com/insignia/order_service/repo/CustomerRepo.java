package com.insignia.order_service.repo;

import com.insignia.order_service.entity.Customer;
import com.insignia.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
