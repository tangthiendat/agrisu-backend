package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.OrderDTO;
import com.ttdat.agrisubackend.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.ok(orderService.add(order));
    }
}
