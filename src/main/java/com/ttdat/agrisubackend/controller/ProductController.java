package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @PostMapping("/")
    public ProductDTO addProduct(@RequestBody ProductDTO newProduct) {
        return productService.add(newProduct);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO product, @PathVariable String id) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.delete(id);
    }

}
