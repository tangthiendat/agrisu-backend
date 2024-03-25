package com.ttdat.agrisubackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private String productId;
    private String productName;
    private ProductTypeDTO productType;
    private int stockQuantity;
    private List<ProductUnitDTO> productUnits;
}
