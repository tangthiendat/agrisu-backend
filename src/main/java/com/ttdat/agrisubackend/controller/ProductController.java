package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(productServiceImpl.getProducts(page, pageSize));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO newProduct) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productServiceImpl.add(newProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product, @PathVariable String id) {
        return ResponseEntity.ok(productServiceImpl.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam String query) {
        return ResponseEntity.ok(productServiceImpl.searchProducts(query));
    }

}
