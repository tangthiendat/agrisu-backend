package com.ttdat.agrisubackend.dto;

import com.ttdat.agrisubackend.entity.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private BigDecimal receivable;
    private List<OrderDTO> orders;
}
