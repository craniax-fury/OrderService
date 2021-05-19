package com.insignia.order_service.service;

import com.insignia.order_service.entity.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    String saveOrder(PlaceOrderRequest request);
    List<Order> getAllOrders();
    String deleteCustomerOrder(int orderId);

    String saveCustomer(Customer customer);

    ResponseEntity<GetCustomerOrdersResponse> getCustomerOrders(GetCustomerOrderRequest request);
}
