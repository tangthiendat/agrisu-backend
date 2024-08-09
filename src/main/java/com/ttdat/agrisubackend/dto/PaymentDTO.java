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
public class PaymentDTO {
    String paymentId;
    LocalDateTime createdAt;
    SupplierDTO supplier;
    BigDecimal supplierCurrentDebt;
    BigDecimal paidAmount;
    BigDecimal supplierNextDebt;
}
