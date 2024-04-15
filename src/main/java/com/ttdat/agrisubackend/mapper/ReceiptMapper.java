package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.entity.Receipt;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapper {

    private final CustomerMapper customerMapper;

    public ReceiptMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public ReceiptDTO toDTO(Receipt receipt) {
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setReceiptId(receipt.getReceiptId());
        receiptDTO.setCustomer(customerMapper.toDTO(receipt.getCustomer()));
        receiptDTO.setPaidAmount(receipt.getPaidAmount());
        receiptDTO.setCustomerNextDebt(receipt.getCustomerNextDebt());
        receiptDTO.setCreatedAt(receipt.getCreatedAt());
        return receiptDTO;
    }

    public Receipt toReceipt(ReceiptDTO receiptDTO) {
        Receipt receipt = new Receipt();
        receipt.setReceiptId(receiptDTO.getReceiptId());
        receipt.setCustomer(customerMapper.toCustomer(receiptDTO.getCustomer()));
        receipt.setPaidAmount(receiptDTO.getPaidAmount());
        receipt.setCustomerNextDebt(receiptDTO.getCustomerNextDebt());
        return receipt;
    }
}
