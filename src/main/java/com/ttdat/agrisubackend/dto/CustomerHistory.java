package com.ttdat.agrisubackend.dto;

import jakarta.persistence.SqlResultSetMapping;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class CustomerHistory {
    private String id;
    private LocalDateTime createdAt;
    private String type;
    private BigDecimal currentDebt;
    private BigDecimal value;
    private BigDecimal payment;
    private BigDecimal nextDebt;
}
