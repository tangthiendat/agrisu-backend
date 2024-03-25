package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.dto.ProductUnitDTO;
import com.ttdat.agrisubackend.mapper.ProductMapper;
import com.ttdat.agrisubackend.mapper.ProductTypeMapper;
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

    public ProductDTO update(ProductDTO productDTO) {
        Product savedProduct = productRepository.save(productMapper.toModel(productDTO));
        Set<ProductUnit> productUnits = productDTO.getProductUnits().stream().map(productUnitMapper::toModel).collect(Collectors.toSet());
        productUnits.forEach(productUnit -> productUnit.setProduct(savedProduct));
        List<ProductUnit> savedProductUnits = productUnitRepository.saveAll(productUnits);
        savedProduct.setProductUnits(new HashSet<>(savedProductUnits));
        return productMapper.toDto(savedProduct);
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }
}
