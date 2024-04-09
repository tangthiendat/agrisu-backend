package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ProductTypeDTO;
import com.ttdat.agrisubackend.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-types")
@CrossOrigin(origins = "*")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ProductTypeDTO>> getAll() {
        return ResponseEntity.ok(productTypeService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductTypeDTO> create(@RequestBody ProductTypeDTO productTypeDTO) {
        return ResponseEntity.ok(productTypeService.create(productTypeDTO));
    }
}
