package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.dto.SupplierHistory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {
    Page<SupplierDTO> getSuppliers(int page, int pageSize);
    SupplierDTO add(SupplierDTO supplierDTO);
    SupplierDTO update(String id, SupplierDTO supplierDTO);
    void delete(String id);
    List<SupplierDTO> searchSuppliers(String query);
    List<SupplierHistory> getSupplierHistory(String supplierId);
}
