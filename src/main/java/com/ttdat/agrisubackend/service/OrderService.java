package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.OrderDTO;
import com.ttdat.agrisubackend.entity.Order;
import com.ttdat.agrisubackend.entity.OrderDetail;
import com.ttdat.agrisubackend.mapper.OrderDetailMapper;
import com.ttdat.agrisubackend.mapper.OrderMapper;
import com.ttdat.agrisubackend.repository.OrderDetailRepository;
import com.ttdat.agrisubackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailRepository orderDetailsRepository;
    private final OrderDetailMapper orderDetailMapper;

    @Transactional
    public OrderDTO add(OrderDTO orderDTO) {
        Order savedOrder = orderRepository.save(orderMapper.toOrder(orderDTO));
        Set<OrderDetail> orderDetails = orderDTO.getOrderDetails().stream()
                .map(orderDetailMapper::toOrderDetail)
                .peek(orderDetail -> orderDetail.setOrder(savedOrder))
                .collect(Collectors.toSet());
        List<OrderDetail> savedOrderDetails = orderDetailsRepository.saveAll(orderDetails);
        savedOrder.setOrderDetails(new HashSet<>(savedOrderDetails));
        return orderMapper.toDTO(savedOrder);
    }

    public List<OrderDTO> getOrdersByCustomerId(String customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

}
