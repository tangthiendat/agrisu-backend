package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.dto.CustomerHistory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Page<CustomerDTO> getCustomers(int page, int pageSize);
    CustomerDTO add(CustomerDTO customerDTO);
    CustomerDTO update(String id, CustomerDTO customerDTO);
    void delete(String id);
    List<CustomerDTO> searchCustomers(String query);
    List<CustomerHistory> getCustomerHistory(String customerId);
}
