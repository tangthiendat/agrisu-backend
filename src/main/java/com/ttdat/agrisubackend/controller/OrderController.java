package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.OrderDTO;
import com.ttdat.agrisubackend.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.ok(orderService.add(order));
    }
}
