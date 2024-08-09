package com.ttdat.agrisubackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierDTO {
    String supplierId;
    String supplierName;
    String phoneNumber;
    String address;
    String taxCode;
    BigDecimal payable;
}
