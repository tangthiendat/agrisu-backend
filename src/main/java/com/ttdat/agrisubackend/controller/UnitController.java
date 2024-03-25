package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.UnitDTO;
import com.ttdat.agrisubackend.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
@CrossOrigin(origins = "*")
public class UnitController {

    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/")
    public List<UnitDTO> getAll(){
        return unitService.getAll();
    }

    @PostMapping("/")
    public UnitDTO create(@RequestBody UnitDTO unitDTO) {
        return unitService.create(unitDTO);
    }

}
