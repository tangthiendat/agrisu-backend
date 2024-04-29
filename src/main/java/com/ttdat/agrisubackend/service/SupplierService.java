package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.entity.Supplier;
import com.ttdat.agrisubackend.mapper.SupplierMapper;
import com.ttdat.agrisubackend.repository.SupplierRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    public List<SupplierDTO> getPaginatedSuppliers(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<Supplier> suppliers = supplierRepository.findAllByDeleted(false, pageable).getContent();
        return suppliers.stream().map(supplierMapper::toDTO).toList();
    }

    @Transactional
    public SupplierDTO add(SupplierDTO supplierDTO) {
        Supplier savedSupplier = supplierRepository.save(supplierMapper.toSupplier(supplierDTO));
        return supplierMapper.toDTO(savedSupplier);
    }

    @Transactional
    public SupplierDTO update(String id, SupplierDTO supplierDTO) {
        Supplier supplierToUpdate = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        Supplier convertedSupplier = supplierMapper.toSupplier(supplierDTO);
        supplierToUpdate.setSupplierName(convertedSupplier.getSupplierName());
        supplierToUpdate.setPhoneNumber(convertedSupplier.getPhoneNumber());
        supplierToUpdate.setAddress(convertedSupplier.getAddress());
        supplierToUpdate.setTaxCode(convertedSupplier.getTaxCode());
        supplierToUpdate.setPayable(convertedSupplier.getPayable());
        Supplier savedSupplier = supplierRepository.save(supplierToUpdate);
        return supplierMapper.toDTO(savedSupplier);
    }

    @Transactional
    public void delete(String id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        supplier.setDeleted(true);
        supplierRepository.save(supplier);
    }

    public List<SupplierDTO> searchSuppliers(String query){
        List<Supplier> suppliers = supplierRepository.searchByNameOrPhone(query);
        return suppliers.stream().map(supplierMapper::toDTO).toList();
    }

    public Long countSuppliers(){
        return supplierRepository.count();
    }
}
