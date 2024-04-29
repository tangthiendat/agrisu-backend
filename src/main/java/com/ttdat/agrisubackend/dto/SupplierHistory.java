package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SupplierHistory {
    private String id;
    private LocalDateTime createdAt;
    private String type;
    private BigDecimal currentDebt;
    private BigDecimal value;
    private BigDecimal payment;
    private BigDecimal nextDebt;
}
