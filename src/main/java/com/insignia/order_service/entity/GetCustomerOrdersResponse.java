package com.insignia.order_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetCustomerOrdersResponse {

    List<Order> orders;

}
