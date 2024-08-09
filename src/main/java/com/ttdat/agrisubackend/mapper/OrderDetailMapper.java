package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.OrderDetailDTO;
import com.ttdat.agrisubackend.entity.OrderDetail;
import org.mapstruct.Mapper;

@Mapper(uses = {ProductMapper.class, UnitMapper.class})
public interface OrderDetailMapper {
    OrderDetailDTO toDTO(OrderDetail orderDetails);
    OrderDetail toOrderDetail(OrderDetailDTO orderDetailsDTO);
}
