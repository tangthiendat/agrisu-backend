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

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getSuppliers(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(supplierService.getPaginatedSuppliers(page, pageSize));
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.ok(supplierService.add(supplierDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplier, @PathVariable String id) {
        return ResponseEntity.ok(supplierService.update(id, supplier));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countSuppliers() {
        return ResponseEntity.ok(supplierService.countSuppliers());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SupplierDTO>> searchSuppliers(@RequestParam String query) {
        return ResponseEntity.ok(supplierService.searchSuppliers(query));
    }
}
