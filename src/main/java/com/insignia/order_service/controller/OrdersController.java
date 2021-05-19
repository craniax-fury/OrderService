package com.insignia.order_service.controller;

import com.insignia.order_service.entity.*;
import com.insignia.order_service.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<Order> getAllOrders(){
            return orderService.getAllOrders();
    }

    @PostMapping("/myOrders")
    public ResponseEntity<GetCustomerOrdersResponse> getCustomerOrders(@Valid @RequestBody GetCustomerOrderRequest request){
        return orderService.getCustomerOrders(request);
    }

    @PostMapping()
    public String saveOrder(@RequestBody PlaceOrderRequest request) {
        return orderService.saveOrder(request);
    }
}
