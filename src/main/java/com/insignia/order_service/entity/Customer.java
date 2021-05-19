package com.insignia.order_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer_cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    private String customerName;
    private String customerAddress;


}
