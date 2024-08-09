package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.WarehouseExportDTO;
import com.ttdat.agrisubackend.service.WarehouseExportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/warehouse-exports")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WarehouseExportController {

    WarehouseExportService warehouseExportService;

    @PostMapping
    public ResponseEntity<WarehouseExportDTO> addWarehouseExport(@RequestBody WarehouseExportDTO warehouseExportDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseExportService.add(warehouseExportDTO));
    }
}
