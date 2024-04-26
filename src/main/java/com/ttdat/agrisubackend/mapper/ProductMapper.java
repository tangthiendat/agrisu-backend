package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ProductDTO;
import com.ttdat.agrisubackend.entity.Product;
import com.ttdat.agrisubackend.entity.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final ProductUnitMapper productUnitMapper;

    @Autowired
    public ProductMapper(ProductUnitMapper productUnitMapper) {
        this.productUnitMapper = productUnitMapper;
    }

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setStockQuantity(product.getStockQuantity());
        productDTO.setProductUnits(product.getProductUnits().stream().map(productUnitMapper::toDTO)
                .collect(Collectors.toList()));
        productDTO.setDisplayedProductUnit(product.getProductUnits().stream()
                .filter(ProductUnit::isDefault)
                .map(productUnitMapper::toDTO)
                .findFirst()
                .orElse(null));
        return productDTO;
    }

    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setProductUnits(productDTO.getProductUnits().stream().map(productUnitMapper::toProductUnit)
                .collect(Collectors.toSet()));
        return product;
    }
}
