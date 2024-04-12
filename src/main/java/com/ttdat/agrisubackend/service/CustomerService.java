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


import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final OrderService orderService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper,
                           OrderService orderService) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.orderService = orderService;
    }

    public List<CustomerDTO> getPaginatedCustomers(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<Customer> customers = customerRepository.findAll(pageable).getContent();
        return customers.stream().map(customer -> {
            CustomerDTO customerDTO = customerMapper.toDTO(customer);
            customerDTO.setOrders(orderService.getOrdersByCustomerId(customer.getCustomerId()));
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

    public List<CustomerDTO> searchCustomers(String query){
        List<Customer> customers = customerRepository.searchByNameOrPhone(query);
        return customers.stream().map(customerMapper::toDTO).toList();
    }


}
