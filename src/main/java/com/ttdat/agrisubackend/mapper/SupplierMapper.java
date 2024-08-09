package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.SupplierDTO;
import com.ttdat.agrisubackend.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper
public interface SupplierMapper {
    SupplierDTO toDTO(Supplier supplier);
    Supplier toSupplier(SupplierDTO supplierDTO);
}
