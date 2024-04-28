package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class WarehouseReceiptDTO {
    private String warehouseReceiptId;
    private LocalDateTime createdAt;
    private SupplierDTO supplier;
    private BigDecimal totalValue;
    private BigDecimal supplierCurrentDebt;
    private BigDecimal supplierNextDebt;
    private Set<WarehouseReceiptDetailDTO> warehouseReceiptDetails;
}
