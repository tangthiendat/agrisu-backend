package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.entity.WarehouseReceipt;
import org.mapstruct.Mapper;

@Mapper(uses = {SupplierMapper.class, WarehouseReceiptDetailMapper.class})
public interface WarehouseReceiptMapper {
    WarehouseReceiptDTO toDTO(WarehouseReceipt warehouseReceipt);
    WarehouseReceipt toWarehouseReceipt(WarehouseReceiptDTO warehouseReceiptDTO);
}
