package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.WarehouseReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReceiptDetailRepository extends JpaRepository<WarehouseReceiptDetail, Long>{
}
