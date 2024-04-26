package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public SupplierDTO toDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierId(supplier.getSupplierId());
        supplierDTO.setSupplierName(supplier.getSupplierName());
        supplierDTO.setPhoneNumber(supplier.getPhoneNumber());
        supplierDTO.setAddress(supplier.getAddress());
        supplierDTO.setPayable(supplier.getPayable());
        return supplierDTO;
    }

    public Supplier toSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(supplierDTO.getSupplierId());
        supplier.setSupplierName(supplierDTO.getSupplierName());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setPayable(supplierDTO.getPayable());
        return supplier;
    }
}
