package com.ttdat.agrisubackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerHistory {
    String id;
    LocalDateTime createdAt;
    String type;
    BigDecimal currentDebt;
    BigDecimal value;
    BigDecimal payment;
    BigDecimal nextDebt;
}
