package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ProductTypeDTO;
import com.ttdat.agrisubackend.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-types")
@CrossOrigin(origins = "*")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/")
    public List<ProductTypeDTO> getAll() {
        return productTypeService.getAll();
    }

    @PostMapping("/")
    public ProductTypeDTO create(@RequestBody ProductTypeDTO productTypeDTO) {
        return productTypeService.create(productTypeDTO);
    }
}
