package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.OrderDTO;
import com.ttdat.agrisubackend.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final CustomerMapper customerMapper;
    private final OrderDetailMapper orderDetailMapper;

    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCustomer(customerMapper.toDTO(order.getCustomer()));
        orderDTO.setTotalValue(order.getTotalValue());
        orderDTO.setCustomerPayment(order.getCustomerPayment());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setOrderDetails(order.getOrderDetails().stream()
                .map(orderDetailMapper::toDTO)
                .collect(Collectors.toSet()));
        return orderDTO;
    }

    public Order toOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setCustomer(customerMapper.toCustomer(orderDTO.getCustomer()));
        order.setTotalValue(orderDTO.getTotalValue());
        order.setCustomerPayment(orderDTO.getCustomerPayment());
        return order;
    }
}
