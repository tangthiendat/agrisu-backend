package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ProductUnitDTO;
import com.ttdat.agrisubackend.entity.ProductUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UnitMapper.class})
public interface ProductUnitMapper {
    @Mapping(source = "default", target = "isDefault")
    ProductUnitDTO toDTO(ProductUnit productUnit);
    ProductUnit toProductUnit(ProductUnitDTO productUnitDTO);
}
