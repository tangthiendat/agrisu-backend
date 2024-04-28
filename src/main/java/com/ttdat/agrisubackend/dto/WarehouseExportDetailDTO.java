package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WarehouseExportDetailDTO {
    private Long id;
    private ProductDTO product;
    private UnitDTO unit;
    private BigDecimal unitPrice;
    private Integer quantity;
}
