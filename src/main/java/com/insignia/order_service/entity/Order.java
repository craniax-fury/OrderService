package com.insignia.order_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @OneToOne(targetEntity = Customer.class,cascade =CascadeType.MERGE)
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_product"
            ,joinColumns =@JoinColumn(name = "order_id")
            ,inverseJoinColumns = @JoinColumn(name = "pid")
    )
    private List<Product> products;
}
