package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.WarehouseExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseExportRepository extends JpaRepository<WarehouseExport, String> {
}
