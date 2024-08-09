package com.ttdat.agrisubackend.service.impl;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.entity.Receipt;
import com.ttdat.agrisubackend.mapper.ReceiptMapper;
import com.ttdat.agrisubackend.repository.ReceiptRepository;
import com.ttdat.agrisubackend.service.ReceiptService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReceiptServiceImpl implements ReceiptService {

    ReceiptRepository receiptRepository;
    ReceiptMapper receiptMapper;

    @Override
    @Transactional
    public ReceiptDTO add(ReceiptDTO receiptDTO) {
        Receipt savedReceipt = receiptRepository.save(receiptMapper.toReceipt(receiptDTO));
        return receiptMapper.toDTO(savedReceipt);
    }

}
