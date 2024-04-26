package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.GoodReceiptDTO;
import com.ttdat.agrisubackend.entity.GoodReceipt;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GoodReceiptMapper {
    private final SupplierMapper supplierMapper;
    private final GoodReceiptDetailMapper goodReceiptDetailMapper;

    public GoodReceiptMapper(SupplierMapper supplierMapper, GoodReceiptDetailMapper goodReceiptDetailMapper) {
        this.supplierMapper = supplierMapper;
        this.goodReceiptDetailMapper = goodReceiptDetailMapper;
    }

    public GoodReceiptDTO toDTO(GoodReceipt goodReceipt) {
        GoodReceiptDTO goodReceiptDTO = new GoodReceiptDTO();
        goodReceiptDTO.setGoodReceiptId(goodReceipt.getGoodReceiptId());
        goodReceiptDTO.setSupplier(supplierMapper.toDTO(goodReceipt.getSupplier()));
        goodReceiptDTO.setTotalValue(goodReceipt.getTotalValue());
        goodReceiptDTO.setSupplierCurrentDebt(goodReceipt.getSupplierCurrentDebt());
        goodReceiptDTO.setSupplierNextDebt(goodReceipt.getSupplierNextDebt());
        goodReceiptDTO.setGoodReceiptDetails(goodReceipt.getGoodReceiptDetails().stream()
                .map(goodReceiptDetailMapper::toDTO)
                .collect(Collectors.toSet()));
        goodReceiptDTO.setCreatedAt(goodReceipt.getCreatedAt());
        return goodReceiptDTO;
    }

    public GoodReceipt toGoodReceipt(GoodReceiptDTO goodReceiptDTO) {
        GoodReceipt goodReceipt = new GoodReceipt();
        goodReceipt.setGoodReceiptId(goodReceiptDTO.getGoodReceiptId());
        goodReceipt.setTotalValue(goodReceiptDTO.getTotalValue());
        goodReceipt.setSupplierCurrentDebt(goodReceiptDTO.getSupplierCurrentDebt());
        goodReceipt.setSupplierNextDebt(goodReceiptDTO.getSupplierNextDebt());
        goodReceipt.setSupplier(supplierMapper.toSupplier(goodReceiptDTO.getSupplier()));
        goodReceipt.setGoodReceiptDetails(goodReceiptDTO.getGoodReceiptDetails().stream()
                .map(goodReceiptDetailMapper::toGoodReceiptDetail)
                .collect(Collectors.toSet()));
        return goodReceipt;
    }
}
