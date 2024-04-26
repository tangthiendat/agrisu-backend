package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.GoodReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodReceiptRepository extends JpaRepository<GoodReceipt, String> {
}
