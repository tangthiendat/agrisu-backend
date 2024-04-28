package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SupplierDTO {
    private String supplierId;
    private String supplierName;
    private String phoneNumber;
    private String address;
    private String taxCode;
    private BigDecimal payable;
}
