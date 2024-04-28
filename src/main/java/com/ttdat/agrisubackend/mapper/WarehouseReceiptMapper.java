package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.entity.WarehouseReceipt;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WarehouseReceiptMapper {
    private final SupplierMapper supplierMapper;
    private final WarehouseReceiptDetailMapper warehouseReceiptDetailMapper;

    public WarehouseReceiptMapper(SupplierMapper supplierMapper, WarehouseReceiptDetailMapper warehouseReceiptDetailMapper) {
        this.supplierMapper = supplierMapper;
        this.warehouseReceiptDetailMapper = warehouseReceiptDetailMapper;
    }

    public WarehouseReceiptDTO toDTO(WarehouseReceipt warehouseReceipt) {
        WarehouseReceiptDTO warehouseReceiptDTO = new WarehouseReceiptDTO();
        warehouseReceiptDTO.setWarehouseReceiptId(warehouseReceipt.getWarehouseReceiptId());
        warehouseReceiptDTO.setSupplier(supplierMapper.toDTO(warehouseReceipt.getSupplier()));
        warehouseReceiptDTO.setTotalValue(warehouseReceipt.getTotalValue());
        warehouseReceiptDTO.setSupplierCurrentDebt(warehouseReceipt.getSupplierCurrentDebt());
        warehouseReceiptDTO.setSupplierNextDebt(warehouseReceipt.getSupplierNextDebt());
        warehouseReceiptDTO.setWarehouseReceiptDetails(warehouseReceipt.getWarehouseReceiptDetails().stream()
                .map(warehouseReceiptDetailMapper::toDTO)
                .collect(Collectors.toSet()));
        warehouseReceiptDTO.setCreatedAt(warehouseReceipt.getCreatedAt());
        return warehouseReceiptDTO;
    }

    public WarehouseReceipt toWarehouseReceipt(WarehouseReceiptDTO warehouseReceiptDTO) {
        WarehouseReceipt warehouseReceipt = new WarehouseReceipt();
        warehouseReceipt.setWarehouseReceiptId(warehouseReceiptDTO.getWarehouseReceiptId());
        warehouseReceipt.setTotalValue(warehouseReceiptDTO.getTotalValue());
        warehouseReceipt.setSupplierCurrentDebt(warehouseReceiptDTO.getSupplierCurrentDebt());
        warehouseReceipt.setSupplierNextDebt(warehouseReceiptDTO.getSupplierNextDebt());
        warehouseReceipt.setSupplier(supplierMapper.toSupplier(warehouseReceiptDTO.getSupplier()));
        warehouseReceipt.setWarehouseReceiptDetails(warehouseReceiptDTO.getWarehouseReceiptDetails().stream()
                .map(warehouseReceiptDetailMapper::toWarehouseReceiptDetail)
                .collect(Collectors.toSet()));
        return warehouseReceipt;
    }
}
