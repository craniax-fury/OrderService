package com.insignia.order_service.service;

import com.insignia.order_service.entity.*;
import com.insignia.order_service.repo.CustomerRepo;
import com.insignia.order_service.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;

    public OrderServiceImpl(OrderRepo orderRepo, CustomerRepo customerRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
    }

    EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager em) {
        entityManager = em;
    }

    @Override
    @Transactional
    public String saveOrder(PlaceOrderRequest request) {
        Order order = new Order();
        Customer customer = new Customer();
        customer.setCustomerId(request.getCustomerId());
        customer.setCustomerName(request.getCustomerName());
        customer.setCustomerAddress(request.getCustomerAddress());
        order.setCustomer(customer);
        order.setProducts(request.getProducts());
        orderRepo.save(order);
        return "Success";
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public String deleteCustomerOrder(int orderId) {
        return null;
    }

    @Override
    public String saveCustomer(Customer customer) {
        customerRepo.save(customer);
        return "success";
    }

    @Override
    public ResponseEntity<GetCustomerOrdersResponse> getCustomerOrders(GetCustomerOrderRequest request) {
        GetCustomerOrdersResponse response = new GetCustomerOrdersResponse();
        Customer customer = new Customer(request.getCustomerId(),request.getCustomerName(), request.getCustomerAddress());
        response.setOrders(entityManager.createQuery("Select o from Order o where o.customer=:cust")
                .setParameter("cust",customer).getResultList());
        return new ResponseEntity<GetCustomerOrdersResponse>(response, HttpStatus.OK);


    }
}
