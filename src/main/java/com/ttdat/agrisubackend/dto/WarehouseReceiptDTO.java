package com.ttdat.agrisubackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseReceiptDTO {
    String warehouseReceiptId;
    LocalDateTime createdAt;
    SupplierDTO supplier;
    BigDecimal totalValue;
    BigDecimal supplierCurrentDebt;
    BigDecimal supplierNextDebt;
    Set<WarehouseReceiptDetailDTO> warehouseReceiptDetails;
}
