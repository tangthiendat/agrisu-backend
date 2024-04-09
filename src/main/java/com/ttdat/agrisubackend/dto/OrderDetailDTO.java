package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDTO {
    private Long id;
    private ProductDTO product;
    private UnitDTO unit;
    private BigDecimal unitPrice;
    private Integer quantity;
}
