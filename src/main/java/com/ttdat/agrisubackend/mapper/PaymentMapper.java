package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.PaymentDTO;
import com.ttdat.agrisubackend.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMapper {

    private final SupplierMapper supplierMapper;

    public PaymentDTO toDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(payment.getPaymentId());
        paymentDTO.setSupplier(supplierMapper.toDTO(payment.getSupplier()));
        paymentDTO.setSupplierCurrentDebt(payment.getSupplierCurrentDebt());
        paymentDTO.setPaidAmount(payment.getPaidAmount());
        paymentDTO.setSupplierNextDebt(payment.getSupplierNextDebt());
        paymentDTO.setCreatedAt(payment.getCreatedAt());
        return paymentDTO;
    }

    public Payment toPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentDTO.getPaymentId());
        payment.setSupplier(supplierMapper.toSupplier(paymentDTO.getSupplier()));
        payment.setSupplierCurrentDebt(paymentDTO.getSupplierCurrentDebt());
        payment.setPaidAmount(paymentDTO.getPaidAmount());
        payment.setSupplierNextDebt(paymentDTO.getSupplierNextDebt());
        return payment;
    }


}
