package com.insignia.order_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetCustomerOrderRequest {

    @NotNull(message = "customer id is required")
    private Integer customerId;
    @NotBlank
    private String customerName;
    @NotBlank
    private String customerAddress;
}
