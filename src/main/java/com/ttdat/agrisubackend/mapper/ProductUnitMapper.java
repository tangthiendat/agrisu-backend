package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ProductUnitDTO;
import com.ttdat.agrisubackend.entity.ProductUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductUnitMapper {

    private final UnitMapper unitMapper;

    public ProductUnitDTO toDTO(ProductUnit productUnit) {
        ProductUnitDTO productUnitDTO = new ProductUnitDTO();
        productUnitDTO.setId(productUnit.getId());
        productUnitDTO.setUnit(unitMapper.toDTO(productUnit.getUnit()));
        productUnitDTO.setBaseQuantity(productUnit.getBaseQuantity());
        productUnitDTO.setOriginalPrice(productUnit.getOriginalPrice());
        productUnitDTO.setSellingPrice(productUnit.getSellingPrice());
        productUnitDTO.setDefault(productUnit.isDefault());
        return productUnitDTO;
    }

    public ProductUnit toProductUnit(ProductUnitDTO productUnitDTO) {
        ProductUnit productUnit = new ProductUnit();
        productUnit.setId(productUnitDTO.getId());
        productUnit.setUnit(unitMapper.toUnit(productUnitDTO.getUnit()));
        productUnit.setBaseQuantity(productUnitDTO.getBaseQuantity());
        productUnit.setOriginalPrice(productUnitDTO.getOriginalPrice());
        productUnit.setSellingPrice(productUnitDTO.getSellingPrice());
        productUnit.setDefault(productUnitDTO.isDefault());
        return productUnit;
    }
}
