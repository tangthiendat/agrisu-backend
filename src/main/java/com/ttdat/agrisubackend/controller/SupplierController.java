package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.ok(supplierService.add(supplierDTO));
    }

    @GetMapping("/search")
    public ResponseEntity<List<SupplierDTO>> searchSuppliers(@RequestParam String query) {
        return ResponseEntity.ok(supplierService.searchSuppliers(query));
    }
}
