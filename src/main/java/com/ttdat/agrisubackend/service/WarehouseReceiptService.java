package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.entity.WarehouseReceipt;
import com.ttdat.agrisubackend.entity.WarehouseReceiptDetail;
import com.ttdat.agrisubackend.mapper.WarehouseReceiptDetailMapper;
import com.ttdat.agrisubackend.mapper.WarehouseReceiptMapper;
import com.ttdat.agrisubackend.repository.GoodReceiptDetailRepository;
import com.ttdat.agrisubackend.repository.GoodReceiptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WarehouseReceiptService {
    private final GoodReceiptRepository goodReceiptRepository;
    private final WarehouseReceiptMapper warehouseReceiptMapper;
    private final GoodReceiptDetailRepository goodReceiptDetailRepository;
    private final WarehouseReceiptDetailMapper warehouseReceiptDetailMapper;

    public WarehouseReceiptService(GoodReceiptRepository goodReceiptRepository, WarehouseReceiptMapper warehouseReceiptMapper,
                                   GoodReceiptDetailRepository goodReceiptDetailRepository, WarehouseReceiptDetailMapper warehouseReceiptDetailMapper) {
        this.goodReceiptRepository = goodReceiptRepository;
        this.warehouseReceiptMapper = warehouseReceiptMapper;
        this.goodReceiptDetailRepository = goodReceiptDetailRepository;
        this.warehouseReceiptDetailMapper = warehouseReceiptDetailMapper;
    }

    @Transactional
    public WarehouseReceiptDTO add(WarehouseReceiptDTO warehouseReceiptDTO) {
        WarehouseReceipt savedWarehouseReceipt = goodReceiptRepository.save(warehouseReceiptMapper.toGoodReceipt(warehouseReceiptDTO));
        Set<WarehouseReceiptDetail> warehouseReceiptDetails = warehouseReceiptDTO.getWarehouseReceiptDetails().stream()
                .map(warehouseReceiptDetailMapper::toGoodReceiptDetail)
                .peek(warehouseReceiptDetail -> warehouseReceiptDetail.setWarehouseReceipt(savedWarehouseReceipt))
                .collect(Collectors.toSet());
        List<WarehouseReceiptDetail> savedWarehouseReceiptDetails = goodReceiptDetailRepository.saveAll(warehouseReceiptDetails);
        savedWarehouseReceipt.setWarehouseReceiptDetails(new HashSet<>(savedWarehouseReceiptDetails));
        return warehouseReceiptMapper.toDTO(savedWarehouseReceipt);
    }
}
