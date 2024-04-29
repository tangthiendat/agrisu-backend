package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.PaymentDTO;
import com.ttdat.agrisubackend.entity.Payment;
import com.ttdat.agrisubackend.mapper.PaymentMapper;
import com.ttdat.agrisubackend.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Transactional
    public PaymentDTO add(PaymentDTO paymentDTO) {
        Payment savedPayment = paymentRepository.save(paymentMapper.toPayment(paymentDTO));
        return paymentMapper.toDTO(savedPayment);
    }

}
