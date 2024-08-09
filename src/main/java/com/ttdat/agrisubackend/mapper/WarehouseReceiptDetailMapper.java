package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDetailDTO;
import com.ttdat.agrisubackend.entity.WarehouseReceiptDetail;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductMapper.class, UnitMapper.class})
public interface WarehouseReceiptDetailMapper {
    WarehouseReceiptDetailDTO toDTO(WarehouseReceiptDetail warehouseReceiptDetail);
    WarehouseReceiptDetail toWarehouseReceiptDetail(WarehouseReceiptDetailDTO warehouseReceiptDetailDTO);
}
