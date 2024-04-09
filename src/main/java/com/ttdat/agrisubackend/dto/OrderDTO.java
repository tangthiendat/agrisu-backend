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
    @JsonProperty("isPaid")
    private boolean isPaid;
    private BigDecimal customerPayment;
//    private BigDecimal change;
    private Set<OrderDetailDTO> orderDetails;
}
