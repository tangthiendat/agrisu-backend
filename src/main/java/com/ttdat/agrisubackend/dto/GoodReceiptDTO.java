package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class GoodReceiptDTO {
    private String goodReceiptId;
    private LocalDateTime createdAt;
    private SupplierDTO supplier;
    private BigDecimal totalValue;
    private BigDecimal supplierCurrentDebt;
    private BigDecimal supplierNextDebt;
    private Set<GoodReceiptDetailDTO> goodReceiptDetails;
}
