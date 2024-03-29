package com.ttdat.agrisubackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUnitDTO {
    private Integer id;
    private UnitDTO unit;
    private Integer baseQuantity;
    private BigDecimal originalPrice;
    private BigDecimal sellingPrice;
    @JsonProperty("isDefault")
    private boolean isDefault;
}
