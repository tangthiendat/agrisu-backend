package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ProductTypeDTO;
import com.ttdat.agrisubackend.mapper.ProductTypeMapper;
import com.ttdat.agrisubackend.model.ProductType;
import com.ttdat.agrisubackend.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository, ProductTypeMapper productTypeMapper){
        this.productTypeRepository = productTypeRepository;
        this.productTypeMapper = productTypeMapper;
    }

    public List<ProductTypeDTO> getAll(){
        List<ProductType> productTypes = productTypeRepository.findAll();
        return productTypes.stream().map(productTypeMapper::toDto).toList();
    }

    public ProductTypeDTO create(ProductTypeDTO productTypeDTO){
        ProductType productType = productTypeMapper.toModel(productTypeDTO);
        ProductType savedProductType = productTypeRepository.save(productType);
        return productTypeMapper.toDto(savedProductType);
    }

}
