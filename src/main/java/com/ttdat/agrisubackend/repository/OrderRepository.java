package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByCustomer_CustomerId(String customerId);
}
