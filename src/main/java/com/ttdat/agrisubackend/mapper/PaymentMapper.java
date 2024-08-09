package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.PaymentDTO;
import com.ttdat.agrisubackend.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(uses = {SupplierMapper.class})
public interface PaymentMapper {
    PaymentDTO toDTO(Payment payment);
    Payment toPayment(PaymentDTO paymentDTO);
}
