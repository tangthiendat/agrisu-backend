package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.WarehouseExportDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseExportDetailRepository extends JpaRepository<WarehouseExportDetail, Integer>{
}
