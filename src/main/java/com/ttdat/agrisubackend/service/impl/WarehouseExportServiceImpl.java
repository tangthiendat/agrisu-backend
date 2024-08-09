package com.ttdat.agrisubackend.service.impl;

import com.ttdat.agrisubackend.dto.WarehouseExportDTO;
import com.ttdat.agrisubackend.entity.WarehouseExport;
import com.ttdat.agrisubackend.entity.WarehouseExportDetail;
import com.ttdat.agrisubackend.mapper.WarehouseExportDetailMapper;
import com.ttdat.agrisubackend.mapper.WarehouseExportMapper;
import com.ttdat.agrisubackend.repository.WarehouseExportDetailRepository;
import com.ttdat.agrisubackend.repository.WarehouseExportRepository;
import com.ttdat.agrisubackend.service.WarehouseExportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WarehouseExportServiceImpl implements WarehouseExportService {

    WarehouseExportRepository warehouseExportRepository;
    WarehouseExportMapper warehouseExportMapper;
    WarehouseExportDetailRepository warehouseExportDetailRepository;
    WarehouseExportDetailMapper warehouseExportDetailMapper;

    @Override
    @Transactional
    public WarehouseExportDTO add(WarehouseExportDTO warehouseExportDTO) {
        WarehouseExport savedWarehouseExport = warehouseExportRepository.save(warehouseExportMapper.toWarehouseExport(warehouseExportDTO));
        Set<WarehouseExportDetail> warehouseExportDetails = warehouseExportDTO.getWarehouseExportDetails().stream()
                .map(warehouseExportDetailMapper::toWarehouseExportDetail)
                .peek(warehouseExportDetail -> warehouseExportDetail.setWarehouseExport(savedWarehouseExport))
                .collect(Collectors.toSet());
        List<WarehouseExportDetail> savedWarehouseExportDetails = warehouseExportDetailRepository.saveAll(warehouseExportDetails);
        savedWarehouseExport.setWarehouseExportDetails(new HashSet<>(savedWarehouseExportDetails));
        return warehouseExportMapper.toDTO(savedWarehouseExport);
    }
}
