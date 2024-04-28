package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.WarehouseExportDTO;
import com.ttdat.agrisubackend.entity.WarehouseExport;
import com.ttdat.agrisubackend.entity.WarehouseExportDetail;
import com.ttdat.agrisubackend.mapper.WarehouseExportDetailMapper;
import com.ttdat.agrisubackend.mapper.WarehouseExportMapper;
import com.ttdat.agrisubackend.repository.WarehouseExportDetailRepository;
import com.ttdat.agrisubackend.repository.WarehouseExportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WarehouseExportService {
    private final WarehouseExportRepository warehouseExportRepository;
    private final WarehouseExportMapper warehouseExportMapper;
    private final WarehouseExportDetailRepository warehouseExportDetailRepository;
    private final WarehouseExportDetailMapper warehouseExportDetailMapper;

    public WarehouseExportService(WarehouseExportRepository warehouseExportRepository, WarehouseExportMapper warehouseExportMapper,
                                   WarehouseExportDetailRepository warehouseExportDetailRepository, WarehouseExportDetailMapper warehouseExportDetailMapper) {
        this.warehouseExportRepository = warehouseExportRepository;
        this.warehouseExportMapper = warehouseExportMapper;
        this.warehouseExportDetailRepository = warehouseExportDetailRepository;
        this.warehouseExportDetailMapper = warehouseExportDetailMapper;
    }

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
