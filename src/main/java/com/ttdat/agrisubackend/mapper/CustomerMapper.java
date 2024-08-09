package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toCustomer(CustomerDTO customerDTO);
}
