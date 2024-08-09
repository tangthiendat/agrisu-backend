package com.ttdat.agrisubackend.service.impl;

import com.ttdat.agrisubackend.dbmapper.CustomerDbMapper;
import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.dto.CustomerHistory;
import com.ttdat.agrisubackend.entity.Customer;
import com.ttdat.agrisubackend.mapper.CustomerMapper;
import com.ttdat.agrisubackend.repository.CustomerRepository;
import com.ttdat.agrisubackend.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;
    CustomerDbMapper customerDbMapper;

    @Override
    public Page<CustomerDTO> getCustomers(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return customerRepository.findAll(pageable).map(customerMapper::toDTO);
    }

    @Override
    @Transactional
    public CustomerDTO add(CustomerDTO customerDTO) {
        Customer savedCustomer = customerRepository.save(customerMapper.toCustomer(customerDTO));
        return customerMapper.toDTO(savedCustomer);
    }

    @Override
    @Transactional
    public CustomerDTO update(String id, CustomerDTO customerDTO) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        Customer convertedCustomer = customerMapper.toCustomer(customerDTO);
        customerToUpdate.setCustomerName(convertedCustomer.getCustomerName());
        customerToUpdate.setPhoneNumber(convertedCustomer.getPhoneNumber());
        customerToUpdate.setAddress(convertedCustomer.getAddress());
        customerToUpdate.setReceivable(convertedCustomer.getReceivable());
        customerToUpdate.setTaxCode(convertedCustomer.getTaxCode());
        return customerMapper.toDTO(customerRepository.save(customerToUpdate));
    }

    @Override
    @Transactional
    public void delete(String id) {
        Customer customerToDelete = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        customerToDelete.setDeleted(true);
        customerRepository.save(customerToDelete);
    }

    @Override
    public List<CustomerDTO> searchCustomers(String query) {
        List<Customer> customers = customerRepository.searchByNameOrPhone(query);
        return customers.stream().map(customerMapper::toDTO).toList();
    }

    @Override
    public List<CustomerHistory> getCustomerHistory(String customerId) {
        return customerDbMapper.getCustomerHistory(customerId);
    }

}
