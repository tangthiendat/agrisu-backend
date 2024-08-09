package com.ttdat.agrisubackend.service.impl;

import com.ttdat.agrisubackend.dto.UnitDTO;
import com.ttdat.agrisubackend.entity.Unit;
import com.ttdat.agrisubackend.mapper.UnitMapper;
import com.ttdat.agrisubackend.repository.UnitRepository;
import com.ttdat.agrisubackend.service.UnitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UnitServiceImpl implements UnitService {

    UnitRepository unitRepository;
    UnitMapper unitMapper;

    @Override
    public List<UnitDTO> getUnits(){
        List<Unit> units = unitRepository.findAll();
        return units.stream().map(unitMapper::toDTO).toList();
    }

    @Override
    public UnitDTO add(UnitDTO unitDTO) {
        Unit savedUnit = unitRepository.save(unitMapper.toUnit(unitDTO));
        return unitMapper.toDTO(savedUnit);
    }
}
