package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.dto.CustomerHistory;
import com.ttdat.agrisubackend.dto.CustomersSummary;
import com.ttdat.agrisubackend.mapper.CustomerMapper;
import com.ttdat.agrisubackend.entity.Customer;
import com.ttdat.agrisubackend.repository.mapper.CustomerDbMapper;
import com.ttdat.agrisubackend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerDbMapper customerDbMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper,
                            CustomerDbMapper customerDbMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.customerDbMapper = customerDbMapper;
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

    @Transactional
    public CustomerDTO update(String id, CustomerDTO customerDTO) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        Customer convertedCustomer = customerMapper.toCustomer(customerDTO);
        customerToUpdate.setCustomerName(convertedCustomer.getCustomerName());
        customerToUpdate.setPhoneNumber(convertedCustomer.getPhoneNumber());
        customerToUpdate.setAddress(convertedCustomer.getAddress());
        customerToUpdate.setReceivable(convertedCustomer.getReceivable());
        CustomerDTO updatedCustomerDTO = customerMapper.toDTO(customerRepository.save(customerToUpdate));
        BigDecimal totalSales = customerRepository.findTotalSalesByCustomerId(customerToUpdate.getCustomerId());
        updatedCustomerDTO.setTotalSales(Objects.requireNonNullElse(totalSales, BigDecimal.ZERO));
        return updatedCustomerDTO;
    }

    public Long countCustomers() {
        return customerRepository.count();
    }

    public List<CustomerDTO> searchCustomers(String query) {
        List<Customer> customers = customerRepository.searchByNameOrPhone(query);
        return customers.stream().map(customerMapper::toDTO).toList();
    }

    public CustomersSummary getCustomersSummary() {
        return customerRepository.getCustomersSummary();
    }

    public List<CustomerHistory> getCustomerHistory(String customerId) {
        return customerDbMapper.getCustomerHistory(customerId);

    }

}
