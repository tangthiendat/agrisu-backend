package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.entity.Supplier;
import com.ttdat.agrisubackend.mapper.SupplierMapper;
import com.ttdat.agrisubackend.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Transactional
    public SupplierDTO add(SupplierDTO supplierDTO) {
        Supplier savedSupplier = supplierRepository.save(supplierMapper.toSupplier(supplierDTO));
        return supplierMapper.toDTO(savedSupplier);
    }

    public List<SupplierDTO> searchSuppliers(String query){
        List<Supplier> suppliers = supplierRepository.searchByNameOrPhone(query);
        return suppliers.stream().map(supplierMapper::toDTO).toList();
    }

}
