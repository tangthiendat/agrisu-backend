package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDTO {
    private String paymentId;
    private LocalDateTime createdAt;
    private SupplierDTO supplier;
    private BigDecimal supplierCurrentDebt;
    private BigDecimal paidAmount;
    private BigDecimal supplierNextDebt;
}
