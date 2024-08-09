package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.entity.Receipt;
import org.mapstruct.Mapper;

@Mapper(uses = {CustomerMapper.class})
public interface ReceiptMapper {
    ReceiptDTO toDTO(Receipt receipt);
    Receipt toReceipt(ReceiptDTO receiptDTO);
}
