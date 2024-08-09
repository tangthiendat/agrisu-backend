package com.ttdat.agrisubackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseExportDetailDTO {
    private Long id;
    private ProductDTO product;
    private UnitDTO unit;
    private BigDecimal unitPrice;
    private Integer quantity;
}
