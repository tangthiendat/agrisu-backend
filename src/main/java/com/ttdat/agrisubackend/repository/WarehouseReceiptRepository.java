package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.WarehouseReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReceiptRepository extends JpaRepository<WarehouseReceipt, String> {
}
