package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.UnitDTO;
import com.ttdat.agrisubackend.entity.Unit;
import org.mapstruct.Mapper;

@Mapper
public interface UnitMapper {
    UnitDTO toDTO(Unit unit);
    Unit toUnit(UnitDTO unitDTO);
}
