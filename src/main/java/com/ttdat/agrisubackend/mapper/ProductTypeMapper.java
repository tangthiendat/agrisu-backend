package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ProductTypeDTO;
import com.ttdat.agrisubackend.model.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeMapper {
    public ProductTypeDTO toDTO(ProductType productType){
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setProductTypeId(productType.getProductTypeId());
        productTypeDTO.setProductTypeName(productType.getProductTypeName());
        return productTypeDTO;
    }

    public ProductType toModel(ProductTypeDTO productTypeDTO){
        ProductType productType = new ProductType();
        productType.setProductTypeId(productTypeDTO.getProductTypeId());
        productType.setProductTypeName(productTypeDTO.getProductTypeName());
        return productType;
    }

}
