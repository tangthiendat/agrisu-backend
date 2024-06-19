package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.entity.WarehouseReceipt;
import com.ttdat.agrisubackend.entity.WarehouseReceiptDetail;
import com.ttdat.agrisubackend.mapper.WarehouseReceiptDetailMapper;
import com.ttdat.agrisubackend.mapper.WarehouseReceiptMapper;
import com.ttdat.agrisubackend.repository.WarehouseReceiptDetailRepository;
import com.ttdat.agrisubackend.repository.WarehouseReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseReceiptServiceImpl implements WarehouseReceiptService {

    private final WarehouseReceiptRepository warehouseReceiptRepository;
    private final WarehouseReceiptMapper warehouseReceiptMapper;
    private final WarehouseReceiptDetailRepository warehouseReceiptDetailRepository;
    private final WarehouseReceiptDetailMapper warehouseReceiptDetailMapper;

    @Transactional
    public WarehouseReceiptDTO add(WarehouseReceiptDTO warehouseReceiptDTO) {
        WarehouseReceipt savedWarehouseReceipt = warehouseReceiptRepository.save(warehouseReceiptMapper.toWarehouseReceipt(warehouseReceiptDTO));
        Set<WarehouseReceiptDetail> warehouseReceiptDetails = warehouseReceiptDTO.getWarehouseReceiptDetails().stream()
                .map(warehouseReceiptDetailMapper::toWarehouseReceiptDetail)
                .peek(warehouseReceiptDetail -> warehouseReceiptDetail.setWarehouseReceipt(savedWarehouseReceipt))
                .collect(Collectors.toSet());
        List<WarehouseReceiptDetail> savedWarehouseReceiptDetails = warehouseReceiptDetailRepository.saveAll(warehouseReceiptDetails);
        savedWarehouseReceipt.setWarehouseReceiptDetails(new HashSet<>(savedWarehouseReceiptDetails));
        return warehouseReceiptMapper.toDTO(savedWarehouseReceipt);
    }
}
