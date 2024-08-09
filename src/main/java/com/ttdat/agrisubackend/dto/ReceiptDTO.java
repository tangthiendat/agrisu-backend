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
public class ReceiptDTO {
    String receiptId;
    LocalDateTime createdAt;
    CustomerDTO customer;
    BigDecimal customerCurrentDebt;
    BigDecimal paidAmount;
    BigDecimal customerNextDebt;
}
