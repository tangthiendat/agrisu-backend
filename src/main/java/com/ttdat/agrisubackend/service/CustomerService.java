package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.mapper.CustomerMapper;
import com.ttdat.agrisubackend.entity.Customer;
import com.ttdat.agrisubackend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> getPaginatedCustomers(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<Customer> customers = customerRepository.findAll(pageable).getContent();
        return customers.stream().map(customer -> {
            CustomerDTO customerDTO = customerMapper.toDTO(customer);
            BigDecimal totalSales = customerRepository.findTotalSalesByCustomerId(customer.getCustomerId());
            customerDTO.setTotalSales(Objects.requireNonNullElse(totalSales, BigDecimal.ZERO));
            return customerDTO;
        }).toList();
    }

    @Transactional
    public CustomerDTO add(CustomerDTO customerDTO) {
        Customer savedCustomer = customerRepository.save(customerMapper.toCustomer(customerDTO));
        return customerMapper.toDTO(savedCustomer);
    }

    public Long countCustomers() {
        return customerRepository.count();
    }

    public List<CustomerDTO> searchCustomers(String query) {
        List<Customer> customers = customerRepository.searchByNameOrPhone(query);
        return customers.stream().map(customerMapper::toDTO).toList();
    }


}
