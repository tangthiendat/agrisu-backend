package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dbmapper.SupplierDbMapper;
import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.dto.SupplierHistory;
import com.ttdat.agrisubackend.entity.Supplier;
import com.ttdat.agrisubackend.mapper.SupplierMapper;
import com.ttdat.agrisubackend.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    private final SupplierDbMapper supplierDbMapper;

    @Override
    public Page<SupplierDTO> getSuppliers(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return supplierRepository.findAll(pageable).map(supplierMapper::toDTO);
    }

    @Override
    @Transactional
    public SupplierDTO add(SupplierDTO supplierDTO) {
        Supplier savedSupplier = supplierRepository.save(supplierMapper.toSupplier(supplierDTO));
        return supplierMapper.toDTO(savedSupplier);
    }

    @Override
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

    @Override
    @Transactional
    public void delete(String id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        supplier.setDeleted(true);
        supplierRepository.save(supplier);
    }

    @Override
    public List<SupplierDTO> searchSuppliers(String query){
        List<Supplier> suppliers = supplierRepository.searchByNameOrPhone(query);
        return suppliers.stream().map(supplierMapper::toDTO).toList();
    }

    @Override
    public List<SupplierHistory> getSupplierHistory(String supplierId){
        return supplierDbMapper.getSupplierHistory(supplierId);
    }
}
