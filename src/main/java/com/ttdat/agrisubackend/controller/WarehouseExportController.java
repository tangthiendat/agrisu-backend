package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.WarehouseExportDTO;
import com.ttdat.agrisubackend.service.WarehouseExportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/warehouse-exports")
public class WarehouseExportController {
    private final WarehouseExportService warehouseExportService;

    public WarehouseExportController(WarehouseExportService warehouseExportService) {
        this.warehouseExportService = warehouseExportService;
    }

    @PostMapping
    public ResponseEntity<WarehouseExportDTO> addWarehouseExport(@RequestBody WarehouseExportDTO warehouseExportDTO) {
        return ResponseEntity.ok(warehouseExportService.add(warehouseExportDTO));
    }
}
