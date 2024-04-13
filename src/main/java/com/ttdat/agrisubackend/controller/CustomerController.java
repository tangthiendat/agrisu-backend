package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.CustomerDTO;
import com.ttdat.agrisubackend.dto.CustomersSummary;
import com.ttdat.agrisubackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(customerService.getPaginatedCustomers(page, pageSize));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.add(customerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer, @PathVariable String id) {
        return ResponseEntity.ok(customerService.update(id, customer));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCustomers() {
        return ResponseEntity.ok(customerService.countCustomers());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerDTO>> searchCustomers(@RequestParam String query) {
        return ResponseEntity.ok(customerService.searchCustomers(query));
    }

    @GetMapping("/summary")
    public ResponseEntity<CustomersSummary> getCustomersSummary() {
        return ResponseEntity.ok(customerService.getCustomersSummary());
    }

}
