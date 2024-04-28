package com.ttdat.agrisubackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDTO {
    private String orderId;
    private LocalDateTime createdAt;
    private CustomerDTO customer;
    private BigDecimal totalValue;
    private BigDecimal customerPayment;
    private Set<OrderDetailDTO> orderDetails;
}
