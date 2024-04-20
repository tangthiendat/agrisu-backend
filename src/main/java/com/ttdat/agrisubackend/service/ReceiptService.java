package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.entity.Receipt;
import com.ttdat.agrisubackend.mapper.ReceiptMapper;
import com.ttdat.agrisubackend.repository.ReceiptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public ReceiptService(ReceiptRepository receiptRepository, ReceiptMapper receiptMapper) {
        this.receiptRepository = receiptRepository;
        this.receiptMapper = receiptMapper;
    }

    @Transactional
    public ReceiptDTO add(ReceiptDTO receiptDTO) {
        Receipt savedReceipt = receiptRepository.save(receiptMapper.toReceipt(receiptDTO));
        return receiptMapper.toDTO(savedReceipt);
    }

}
