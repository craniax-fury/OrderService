package com.insignia.order_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("order")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    private String productName;
    private double price;

    @Transient
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "pid")
            ,inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> order;
}
