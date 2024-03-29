package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.UnitDTO;
import com.ttdat.agrisubackend.model.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper {
    public UnitDTO toDTO(Unit unit){
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setUnitId(unit.getUnitId());
        unitDTO.setUnitName(unit.getUnitName());
        return unitDTO;
    }

    public Unit toModel(UnitDTO unitDTO){
        Unit unit = new Unit();
        unit.setUnitId(unitDTO.getUnitId());
        unit.setUnitName(unitDTO.getUnitName());
        return unit;
    }
}
