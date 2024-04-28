package com.ttdat.agrisubackend.mapper;


import com.ttdat.agrisubackend.dto.WarehouseExportDTO;
import com.ttdat.agrisubackend.entity.WarehouseExport;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WarehouseExportMapper {
    private final CustomerMapper customerMapper;
    private final WarehouseExportDetailMapper warehouseExportDetailMapper;

    public WarehouseExportMapper(CustomerMapper customerMapper, WarehouseExportDetailMapper warehouseExportDetailMapper) {
        this.customerMapper = customerMapper;
        this.warehouseExportDetailMapper = warehouseExportDetailMapper;
    }

    public WarehouseExportDTO toDTO(WarehouseExport warehouseExport) {
        WarehouseExportDTO warehouseExportDTO = new WarehouseExportDTO();
        warehouseExportDTO.setWarehouseExportId(warehouseExport.getWarehouseExportId());
        warehouseExportDTO.setCustomer(customerMapper.toDTO(warehouseExport.getCustomer()));
        warehouseExportDTO.setTotalValue(warehouseExport.getTotalValue());
        warehouseExportDTO.setCustomerCurrentDebt(warehouseExport.getCustomerCurrentDebt());
        warehouseExportDTO.setCustomerNextDebt(warehouseExport.getCustomerNextDebt());
        warehouseExportDTO.setWarehouseExportDetails(warehouseExport.getWarehouseExportDetails().stream()
                .map(warehouseExportDetailMapper::toDTO)
                .collect(Collectors.toSet()));
        warehouseExportDTO.setCreatedAt(warehouseExport.getCreatedAt());
        return warehouseExportDTO;
    }

    public WarehouseExport toWarehouseExport(WarehouseExportDTO warehouseExportDTO) {
        WarehouseExport warehouseExport = new WarehouseExport();
        warehouseExport.setWarehouseExportId(warehouseExportDTO.getWarehouseExportId());
        warehouseExport.setTotalValue(warehouseExportDTO.getTotalValue());
        warehouseExport.setCustomerCurrentDebt(warehouseExportDTO.getCustomerCurrentDebt());
        warehouseExport.setCustomerNextDebt(warehouseExportDTO.getCustomerNextDebt());
        warehouseExport.setCustomer(customerMapper.toCustomer(warehouseExportDTO.getCustomer()));
        warehouseExport.setWarehouseExportDetails(warehouseExportDTO.getWarehouseExportDetails().stream()
                .map(warehouseExportDetailMapper::toWarehouseExportDetail)
                .collect(Collectors.toSet()));
        return warehouseExport;
    }
}
