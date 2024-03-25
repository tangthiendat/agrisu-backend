package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ProductUnitDTO;
import com.ttdat.agrisubackend.mapper.ProductUnitMapper;
import com.ttdat.agrisubackend.model.ProductUnit;
import com.ttdat.agrisubackend.repository.ProductUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class ProductUnitService {

    private final ProductUnitRepository productUnitRepository;
    private final ProductUnitMapper productUnitMapper;


    public ProductUnitService(ProductUnitRepository productUnitRepository, ProductUnitMapper productUnitMapper) {
        this.productUnitRepository = productUnitRepository;
        this.productUnitMapper = productUnitMapper;
    }

    public List<ProductUnitDTO> saveAll(Set<ProductUnitDTO> productUnitSet) {
        List<ProductUnit> productUnits = productUnitRepository.saveAll(
                productUnitSet.stream().map(productUnitMapper::toModel).toList());
        return productUnits.stream().map(productUnitMapper::toDto).toList();
    }
}
