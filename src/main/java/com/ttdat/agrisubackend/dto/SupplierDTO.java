package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SupplierDTO {
    String supplierId;
    String supplierName;
    String phoneNumber;
    String address;
    BigDecimal payable;
    BigDecimal totalPurchase;
}
