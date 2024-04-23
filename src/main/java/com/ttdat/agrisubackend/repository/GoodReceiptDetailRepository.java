package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.GoodReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodReceiptDetailRepository extends JpaRepository<GoodReceiptDetail, Long>{
}
