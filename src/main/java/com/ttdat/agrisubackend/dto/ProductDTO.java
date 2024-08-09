package com.ttdat.agrisubackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    String productId;
    String productName;
    int stockQuantity;
    List<ProductUnitDTO> productUnits;
    ProductUnitDTO displayedProductUnit;
}
