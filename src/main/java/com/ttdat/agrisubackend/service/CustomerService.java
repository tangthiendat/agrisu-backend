package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.mapper.CustomerMapper;
import com.ttdat.agrisubackend.entity.Customer;
import com.ttdat.agrisubackend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public CustomerDTO add(CustomerDTO customerDTO) {
        Customer savedCustomer = customerRepository.save(customerMapper.toCustomer(customerDTO));
        return customerMapper.toDTO(savedCustomer);
    }

    public Long countCustomers() {
        return customerRepository.count();
    }


}
