package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.mapper.ProductMapper;
import com.ttdat.agrisubackend.mapper.ProductUnitMapper;
import com.ttdat.agrisubackend.entity.Product;
import com.ttdat.agrisubackend.entity.ProductUnit;
import com.ttdat.agrisubackend.repository.ProductRepository;
import com.ttdat.agrisubackend.repository.ProductUnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
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
        Product savedProduct = productRepository.save(productMapper.toProduct(productDTO));
        Set<ProductUnit> productUnits = productDTO.getProductUnits().stream()
                .map(productUnitMapper::toProductUnit)
                .peek(productUnit -> productUnit.setProduct(savedProduct))
                .collect(Collectors.toSet());
        List<ProductUnit> savedProductUnits = productUnitRepository.saveAll(productUnits);
        savedProduct.setProductUnits(new HashSet<>(savedProductUnits));
        return productMapper.toDTO(savedProduct);
    }


    @Transactional
    public ProductDTO update(String id, ProductDTO productDTO) {
        // Update productToUpdate
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        Product convertedProduct = productMapper.toProduct(productDTO);
        productToUpdate.setProductName(convertedProduct.getProductName());
        productToUpdate.setProductType(convertedProduct.getProductType());
        productToUpdate.setStockQuantity(convertedProduct.getStockQuantity());
        Product updatedProduct = productRepository.save(productToUpdate);

        Set<ProductUnit> originalProductUnits = productToUpdate.getProductUnits();
        Set<ProductUnit> newProductUnits = convertedProduct.getProductUnits();
        List<ProductUnit> productUnitsToDelete = new ArrayList<>();
        // Delete product units that are not in the newProductUnits if
        // there is less product units in newProductUnits
        for (ProductUnit productUnit : originalProductUnits) {
            boolean isNotInNewProductUnits = newProductUnits.stream()
                    .noneMatch(newProductUnit -> {
                        if (newProductUnit.getId() != null) {
                            return newProductUnit.getId().equals(productUnit.getId());
                        }
                        return false;
                    });
            if (isNotInNewProductUnits) {
                productUnitsToDelete.add(productUnit);
                newProductUnits.removeIf(newProductUnit -> {
                    if (newProductUnit.getId() != null) {
                        return newProductUnit.getId().equals(productUnit.getId());
                    }
                    return false;
                });
            }
        }
        if (!productUnitsToDelete.isEmpty()) {
            productUnitRepository.deleteAll(productUnitsToDelete);
        }
        // Save new product units
        List<ProductUnit> productUnitsToSave = new ArrayList<>(newProductUnits);
        productUnitsToSave.forEach(productUnit -> productUnit.setProduct(updatedProduct));
        List<ProductUnit> savedProductUnits = productUnitRepository.saveAll(productUnitsToSave);
        updatedProduct.setProductUnits(new HashSet<>(savedProductUnits));
        return productMapper.toDTO(updatedProduct);
    }

    @Transactional
    public void delete(String id) {
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        Set<ProductUnit> productUnitsToDelete = productUnitRepository.findByProduct_ProductId(productToDelete.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product units not found for product with id: " + id));
        productUnitRepository.deleteAll(productUnitsToDelete);
        productRepository.delete(productToDelete);
    }

    public List<ProductDTO> getPaginatedProducts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Product> products = productRepository.findAll(pageable).getContent();
        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    public Long countProducts() {
        return productRepository.count();
    }

    public List<ProductDTO> searchProducts(String query) {
        List<Product> products = productRepository.searchByName(query);
        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }
}
