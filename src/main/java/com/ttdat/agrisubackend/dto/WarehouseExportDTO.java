package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class WarehouseExportDTO {
    private String warehouseExportId;
    private LocalDateTime createdAt;
    private CustomerDTO customer;
    private BigDecimal totalValue;
    private BigDecimal customerCurrentDebt;
    private BigDecimal customerNextDebt;
    private Set<WarehouseExportDetailDTO> warehouseExportDetails;
}
