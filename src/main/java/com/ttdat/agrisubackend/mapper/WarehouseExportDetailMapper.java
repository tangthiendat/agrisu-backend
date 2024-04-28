package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.WarehouseExportDetailDTO;
import com.ttdat.agrisubackend.entity.WarehouseExportDetail;
import org.springframework.stereotype.Component;

@Component
public class WarehouseExportDetailMapper {
    private final ProductMapper productMapper;
    private final UnitMapper unitMapper;

    public WarehouseExportDetailMapper(ProductMapper productMapper, UnitMapper unitMapper) {
        this.productMapper = productMapper;
        this.unitMapper = unitMapper;
    }

    public WarehouseExportDetailDTO toDTO(WarehouseExportDetail warehouseExportDetail) {
        WarehouseExportDetailDTO warehouseExportDetailDTO = new WarehouseExportDetailDTO();
        warehouseExportDetailDTO.setId(warehouseExportDetail.getId());
        warehouseExportDetailDTO.setProduct(productMapper.toDTO(warehouseExportDetail.getProduct()));
        warehouseExportDetailDTO.setUnit(unitMapper.toDTO(warehouseExportDetail.getUnit()));
        warehouseExportDetailDTO.setUnitPrice(warehouseExportDetail.getUnitPrice());
        warehouseExportDetailDTO.setQuantity(warehouseExportDetail.getQuantity());
        return warehouseExportDetailDTO;
    }

    public WarehouseExportDetail toWarehouseExportDetail(WarehouseExportDetailDTO warehouseExportDetailDTO) {
        WarehouseExportDetail warehouseExportDetail = new WarehouseExportDetail();
        warehouseExportDetail.setId(warehouseExportDetailDTO.getId());
        warehouseExportDetail.setProduct(productMapper.toProduct(warehouseExportDetailDTO.getProduct()));
        warehouseExportDetail.setUnit(unitMapper.toUnit(warehouseExportDetailDTO.getUnit()));
        warehouseExportDetail.setUnitPrice(warehouseExportDetailDTO.getUnitPrice());
        warehouseExportDetail.setQuantity(warehouseExportDetailDTO.getQuantity());
        return warehouseExportDetail;
    }
}
