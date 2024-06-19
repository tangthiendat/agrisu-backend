package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.entity.Product;
import com.ttdat.agrisubackend.entity.ProductUnit;
import com.ttdat.agrisubackend.mapper.ProductMapper;
import com.ttdat.agrisubackend.mapper.ProductUnitMapper;
import com.ttdat.agrisubackend.repository.ProductRepository;
import com.ttdat.agrisubackend.repository.ProductUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductUnitRepository productUnitRepository;
    private final ProductUnitMapper productUnitMapper;

    @Override
    public Page<ProductDTO> getProducts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageable).map(productMapper::toDTO);
    }

    @Override
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

    @Override
    @Transactional
    public ProductDTO update(String id, ProductDTO productDTO) {
        // Update productToUpdate
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        Product convertedProduct = productMapper.toProduct(productDTO);
        productToUpdate.setProductName(convertedProduct.getProductName());
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

    @Override
    @Transactional
    public void delete(String id) {
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.delete(productToDelete);
    }

    @Override
    public List<ProductDTO> searchProducts(String query) {
        List<Product> products = productRepository.searchByName(query);
        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }
}
