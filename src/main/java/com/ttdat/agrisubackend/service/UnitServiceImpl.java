package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.UnitDTO;
import com.ttdat.agrisubackend.entity.Unit;
import com.ttdat.agrisubackend.mapper.UnitMapper;
import com.ttdat.agrisubackend.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService{

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

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
