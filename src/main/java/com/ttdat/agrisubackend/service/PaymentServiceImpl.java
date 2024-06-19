package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.PaymentDTO;
import com.ttdat.agrisubackend.entity.Payment;
import com.ttdat.agrisubackend.mapper.PaymentMapper;
import com.ttdat.agrisubackend.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    @Transactional
    public PaymentDTO add(PaymentDTO paymentDTO) {
        Payment savedPayment = paymentRepository.save(paymentMapper.toPayment(paymentDTO));
        return paymentMapper.toDTO(savedPayment);
    }

}
