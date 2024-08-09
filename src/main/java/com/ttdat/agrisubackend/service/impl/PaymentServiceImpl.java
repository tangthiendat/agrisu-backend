package com.ttdat.agrisubackend.service.impl;

import com.ttdat.agrisubackend.dto.PaymentDTO;
import com.ttdat.agrisubackend.entity.Payment;
import com.ttdat.agrisubackend.mapper.PaymentMapper;
import com.ttdat.agrisubackend.repository.PaymentRepository;
import com.ttdat.agrisubackend.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentServiceImpl implements PaymentService {

    PaymentRepository paymentRepository;
    PaymentMapper paymentMapper;

    @Override
    @Transactional
    public PaymentDTO add(PaymentDTO paymentDTO) {
        Payment savedPayment = paymentRepository.save(paymentMapper.toPayment(paymentDTO));
        return paymentMapper.toDTO(savedPayment);
    }

}
