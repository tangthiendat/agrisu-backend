package com.ttdat.agrisubackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    String productId;
    String productName;
    int stockQuantity;
    List<ProductUnitDTO> productUnits;
    ProductUnitDTO displayedProductUnit;
}
