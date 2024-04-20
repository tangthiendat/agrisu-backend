package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private BigDecimal receivable;
    private BigDecimal totalSales;
}
