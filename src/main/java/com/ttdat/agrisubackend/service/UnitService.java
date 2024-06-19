package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.UnitDTO;

import java.util.List;

public interface UnitService {
    List<UnitDTO> getUnits();
    UnitDTO add(UnitDTO unitDTO);
}
