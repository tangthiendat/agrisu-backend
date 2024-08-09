package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.WarehouseExportDetailDTO;
import com.ttdat.agrisubackend.entity.WarehouseExportDetail;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductMapper.class, UnitMapper.class})
public interface WarehouseExportDetailMapper {
    WarehouseExportDetailDTO toDTO(WarehouseExportDetail warehouseExportDetail);
    WarehouseExportDetail toWarehouseExportDetail(WarehouseExportDetailDTO warehouseExportDetailDTO);
}
