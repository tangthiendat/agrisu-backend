package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.UnitDTO;
import com.ttdat.agrisubackend.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/units")
public class UnitController {

    private final UnitService unitService;

    @GetMapping
    public ResponseEntity<List<UnitDTO>> getAll(){
        return ResponseEntity.ok(unitService.getAll());
    }

    @PostMapping
    public ResponseEntity<UnitDTO> create(@RequestBody UnitDTO unitDTO) {
        return ResponseEntity.ok(unitService.create(unitDTO));
    }

}
