package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.dto.SupplierHistory;
import com.ttdat.agrisubackend.service.SupplierServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/suppliers")
public class SupplierController {
    private final SupplierServiceImpl supplierServiceImpl;

    @GetMapping
    public ResponseEntity<Page<SupplierDTO>> getSuppliers(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(supplierServiceImpl.getSuppliers(page, pageSize));
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierServiceImpl.add(supplierDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplier, @PathVariable String id) {
        return ResponseEntity.ok(supplierServiceImpl.update(id, supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable String id) {
        supplierServiceImpl.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<SupplierDTO>> searchSuppliers(@RequestParam String query) {
        return ResponseEntity.ok(supplierServiceImpl.searchSuppliers(query));
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<List<SupplierHistory>> getSupplierHistory(@PathVariable String id) {
        return ResponseEntity.ok(supplierServiceImpl.getSupplierHistory(id));
    }
}
