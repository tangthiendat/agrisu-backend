package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setReceivable(customer.getReceivable());
        customerDTO.setTaxCode(customer.getTaxCode());
        return customerDTO;
    }

    public Customer toCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());
        customer.setReceivable(customerDTO.getReceivable());
        customer.setTaxCode(customerDTO.getTaxCode());
        return customer;
    }
}
