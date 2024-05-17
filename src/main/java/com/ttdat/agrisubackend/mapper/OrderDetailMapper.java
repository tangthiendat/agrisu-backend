package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.OrderDetailDTO;
import com.ttdat.agrisubackend.entity.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderDetailMapper {

    private final ProductMapper productMapper;
    private final UnitMapper unitMapper;

    public OrderDetailDTO toDTO(OrderDetail orderDetails) {
        OrderDetailDTO orderDetailsDTO = new OrderDetailDTO();
        orderDetailsDTO.setId(orderDetails.getId());
        orderDetailsDTO.setProduct(productMapper.toDTO(orderDetails.getProduct()));
        orderDetailsDTO.setUnit(unitMapper.toDTO(orderDetails.getUnit()));
        orderDetailsDTO.setUnitPrice(orderDetails.getUnitPrice());
        orderDetailsDTO.setQuantity(orderDetails.getQuantity());
        return orderDetailsDTO;
    }

    public OrderDetail toOrderDetail(OrderDetailDTO orderDetailsDTO) {
        OrderDetail orderDetails = new OrderDetail();
        orderDetails.setId(orderDetailsDTO.getId());
        orderDetails.setProduct(productMapper.toProduct(orderDetailsDTO.getProduct()));
        orderDetails.setUnit(unitMapper.toUnit(orderDetailsDTO.getUnit()));
        orderDetails.setUnitPrice(orderDetailsDTO.getUnitPrice());
        orderDetails.setQuantity(orderDetailsDTO.getQuantity());
        return orderDetails;
    }
}
