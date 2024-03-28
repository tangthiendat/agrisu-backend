package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.mapper.ProductMapper;
import com.ttdat.agrisubackend.mapper.ProductUnitMapper;
import com.ttdat.agrisubackend.model.Product;
import com.ttdat.agrisubackend.model.ProductUnit;
import com.ttdat.agrisubackend.repository.ProductRepository;
import com.ttdat.agrisubackend.repository.ProductUnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductUnitRepository productUnitRepository;
    private final ProductUnitMapper productUnitMapper;


    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper,
                          ProductUnitRepository productUnitRepository, ProductUnitMapper productUnitMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productUnitRepository = productUnitRepository;
        this.productUnitMapper = productUnitMapper;
    }

    @Transactional
    public ProductDTO add(ProductDTO productDTO) {
        Product savedProduct = productRepository.save(productMapper.toModel(productDTO));
        Set<ProductUnit> productUnits = productDTO.getProductUnits().stream()
                .map(productUnitMapper::toModel)
                .peek(productUnit -> productUnit.setProduct(savedProduct))
                .collect(Collectors.toSet());
        System.out.println("PRODUCT UNITS TO SAVE = " + productUnits);
        List<ProductUnit> savedProductUnits = productUnitRepository.saveAll(productUnits);
        savedProduct.setProductUnits(new HashSet<>(savedProductUnits));
        return productMapper.toDTO(savedProduct);
    }


    @Transactional
    public ProductDTO update(String id, ProductDTO productDTO) {
        // Update productToUpdate
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Product convertedProduct = productMapper.toModel(productDTO);
        productToUpdate.setProductName(convertedProduct.getProductName());
        productToUpdate.setProductType(convertedProduct.getProductType());
        productToUpdate.setStockQuantity(convertedProduct.getStockQuantity());
        Product updatedProduct = productRepository.save(productToUpdate);
        // Update productToUpdate units
        Set<ProductUnit> productUnitsToUpdate = productUnitRepository.findByProduct(productToUpdate)
                .orElseThrow(() -> new RuntimeException("Product units not found"));
        productUnitsToUpdate.addAll(productDTO.getProductUnits().stream()
                .map(productUnitMapper::toModel)
                .peek(productUnit -> productUnit.setProduct(updatedProduct))
                .collect(Collectors.toSet()));
        List<ProductUnit> updatedProductUnits = productUnitRepository.saveAll(productUnitsToUpdate);
        updatedProduct.setProductUnits(new HashSet<>(updatedProductUnits));
        return productMapper.toDTO(updatedProduct);
    }

    @Transactional
    public void delete(String id) {
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Set<ProductUnit> productUnitsToDelete = productUnitRepository.findByProduct(productToDelete)
                .orElseThrow(() -> new RuntimeException("Product units not found"));
        productUnitRepository.deleteAll(productUnitsToDelete);
        productRepository.delete(productToDelete);
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }
}
