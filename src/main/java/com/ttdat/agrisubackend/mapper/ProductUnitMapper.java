package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ProductUnitDTO;
import com.ttdat.agrisubackend.entity.ProductUnit;
import org.mapstruct.Mapper;

@Mapper(uses = {UnitMapper.class})
public interface ProductUnitMapper {
    ProductUnitDTO toDTO(ProductUnit productUnit);
    ProductUnit toProductUnit(ProductUnitDTO productUnitDTO);
}
