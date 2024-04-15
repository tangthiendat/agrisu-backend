package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReceiptDTO {
    private String receiptId;
    private LocalDateTime createdAt;
    private CustomerDTO customer;
    private BigDecimal paidAmount;
    private BigDecimal customerNextDebt;
}
