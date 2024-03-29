package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final ProductTypeMapper productTypeMapper;
    private final ProductUnitMapper productUnitMapper;

    @Autowired
    public ProductMapper(ProductTypeMapper productTypeMapper, ProductUnitMapper productUnitMapper) {
        this.productTypeMapper = productTypeMapper;
        this.productUnitMapper = productUnitMapper;
    }

    public ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductType(productTypeMapper.toDto(product.getProductType()));
        productDTO.setStockQuantity(product.getStockQuantity());
        productDTO.setProductUnits(product.getProductUnits().stream().map(productUnitMapper::toDto)
                .collect(Collectors.toList()));

        return productDTO;
    }

    public Product toModel(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setProductType(productTypeMapper.toModel(productDTO.getProductType()));
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setProductUnits(productDTO.getProductUnits().stream().map(productUnitMapper::toModel)
                .collect(Collectors.toSet()));
        return product;
    }
}
