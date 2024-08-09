package com.ttdat.agrisubackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailDTO {
    Long id;
    ProductDTO product;
    UnitDTO unit;
    BigDecimal unitPrice;
    Integer quantity;
}
