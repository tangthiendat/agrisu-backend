package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.OrderDTO;
import com.ttdat.agrisubackend.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderServiceImpl.add(order));
    }
}
