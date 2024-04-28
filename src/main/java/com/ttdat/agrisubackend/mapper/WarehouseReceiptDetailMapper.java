package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDetailDTO;
import com.ttdat.agrisubackend.entity.WarehouseReceiptDetail;
import org.springframework.stereotype.Component;

@Component
public class WarehouseReceiptDetailMapper {
    private final ProductMapper productMapper;
    private final UnitMapper unitMapper;

    public WarehouseReceiptDetailMapper(ProductMapper productMapper, UnitMapper unitMapper) {
        this.productMapper = productMapper;
        this.unitMapper = unitMapper;
    }

    public WarehouseReceiptDetailDTO toDTO(WarehouseReceiptDetail warehouseReceiptDetail) {
        WarehouseReceiptDetailDTO warehouseReceiptDetailDTO = new WarehouseReceiptDetailDTO();
        warehouseReceiptDetailDTO.setId(warehouseReceiptDetail.getId());
        warehouseReceiptDetailDTO.setProduct(productMapper.toDTO(warehouseReceiptDetail.getProduct()));
        warehouseReceiptDetailDTO.setUnit(unitMapper.toDTO(warehouseReceiptDetail.getUnit()));
        warehouseReceiptDetailDTO.setUnitPrice(warehouseReceiptDetail.getUnitPrice());
        warehouseReceiptDetailDTO.setQuantity(warehouseReceiptDetail.getQuantity());
        return warehouseReceiptDetailDTO;
    }

    public WarehouseReceiptDetail toWarehouseReceiptDetail(WarehouseReceiptDetailDTO warehouseReceiptDetailDTO) {
        WarehouseReceiptDetail warehouseReceiptDetail = new WarehouseReceiptDetail();
        warehouseReceiptDetail.setId(warehouseReceiptDetailDTO.getId());
        warehouseReceiptDetail.setProduct(productMapper.toProduct(warehouseReceiptDetailDTO.getProduct()));
        warehouseReceiptDetail.setUnit(unitMapper.toUnit(warehouseReceiptDetailDTO.getUnit()));
        warehouseReceiptDetail.setUnitPrice(warehouseReceiptDetailDTO.getUnitPrice());
        warehouseReceiptDetail.setQuantity(warehouseReceiptDetailDTO.getQuantity());
        return warehouseReceiptDetail;
    }
}
