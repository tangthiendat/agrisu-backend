package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.entity.Product;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductUnitMapper.class})
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toProduct(ProductDTO productDTO);
}
