package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.UnitDTO;
import com.ttdat.agrisubackend.mapper.UnitMapper;
import com.ttdat.agrisubackend.model.Unit;
import com.ttdat.agrisubackend.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

    @Autowired
    public UnitService(UnitRepository unitRepository, UnitMapper unitMapper) {
        this.unitRepository = unitRepository;
        this.unitMapper = unitMapper;
    }

    public List<UnitDTO> getAll(){
        List<Unit> units = unitRepository.findAll();
        return units.stream().map(unitMapper::toDTO).toList();
    }

    public UnitDTO create(UnitDTO unitDTO) {
        Unit savedUnit = unitRepository.save(unitMapper.toModel(unitDTO));
        return unitMapper.toDTO(savedUnit);
    }
}
