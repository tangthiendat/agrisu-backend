package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ProductDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<ProductDTO> getProducts(int page, int size);
    ProductDTO add(ProductDTO productDTO);
    ProductDTO update(String id, ProductDTO productDTO);
    void delete(String id);
    List<ProductDTO> searchProducts(String query);
}
