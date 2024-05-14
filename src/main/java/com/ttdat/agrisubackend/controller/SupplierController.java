package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.dto.SupplierHistory;
import com.ttdat.agrisubackend.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getSuppliers(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(supplierService.getPaginatedSuppliers(page, pageSize));
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.add(supplierDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplier, @PathVariable String id) {
        return ResponseEntity.ok(supplierService.update(id, supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable String id) {
        supplierService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countSuppliers() {
        return ResponseEntity.ok(supplierService.countSuppliers());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SupplierDTO>> searchSuppliers(@RequestParam String query) {
        return ResponseEntity.ok(supplierService.searchSuppliers(query));
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<List<SupplierHistory>> getSupplierHistory(@PathVariable String id) {
        return ResponseEntity.ok(supplierService.getSupplierHistory(id));
    }
}
