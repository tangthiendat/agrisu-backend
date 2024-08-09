package com.ttdat.agrisubackend.service.impl;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.entity.WarehouseReceipt;
import com.ttdat.agrisubackend.entity.WarehouseReceiptDetail;
import com.ttdat.agrisubackend.mapper.WarehouseReceiptDetailMapper;
import com.ttdat.agrisubackend.mapper.WarehouseReceiptMapper;
import com.ttdat.agrisubackend.repository.WarehouseReceiptDetailRepository;
import com.ttdat.agrisubackend.repository.WarehouseReceiptRepository;
import com.ttdat.agrisubackend.service.WarehouseReceiptService;
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
public class WarehouseReceiptServiceImpl implements WarehouseReceiptService {

    WarehouseReceiptRepository warehouseReceiptRepository;
    WarehouseReceiptMapper warehouseReceiptMapper;
    WarehouseReceiptDetailRepository warehouseReceiptDetailRepository;
    WarehouseReceiptDetailMapper warehouseReceiptDetailMapper;

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
