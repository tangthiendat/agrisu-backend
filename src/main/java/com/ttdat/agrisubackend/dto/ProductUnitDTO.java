package com.ttdat.agrisubackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUnitDTO {
    Integer id;
    UnitDTO unit;
    Integer baseQuantity;
    BigDecimal originalPrice;
    BigDecimal sellingPrice;
    @JsonProperty("isDefault")
    boolean isDefault;
}
