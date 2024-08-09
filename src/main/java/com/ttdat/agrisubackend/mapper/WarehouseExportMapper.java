package com.ttdat.agrisubackend.mapper;


import com.ttdat.agrisubackend.dto.WarehouseExportDTO;
import com.ttdat.agrisubackend.entity.WarehouseExport;
import org.mapstruct.Mapper;

@Mapper(uses = {CustomerMapper.class, WarehouseExportDetailMapper.class})
public interface WarehouseExportMapper {
    WarehouseExportDTO toDTO(WarehouseExport warehouseExport);
    WarehouseExport toWarehouseExport(WarehouseExportDTO warehouseExportDTO);
}
