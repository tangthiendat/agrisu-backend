package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.OrderDTO;
import com.ttdat.agrisubackend.entity.Order;
import org.mapstruct.Mapper;

@Mapper(uses = {CustomerMapper.class, OrderDetailMapper.class})
public interface OrderMapper {
    OrderDTO toDTO(Order order);
    Order toOrder(OrderDTO orderDTO);
}
