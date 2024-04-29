package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String>{
}
