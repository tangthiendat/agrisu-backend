package com.ttdat.agrisubackend.dto;

import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerHistory {
    private String id;
    private LocalDateTime createdAt;
    private String type;
    private BigDecimal value;
    private BigDecimal nextDebt;
}
