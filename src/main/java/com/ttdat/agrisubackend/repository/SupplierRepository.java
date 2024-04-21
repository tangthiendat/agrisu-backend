package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
    @Query("SELECT s FROM Supplier s WHERE lower(s.supplierName) LIKE lower(concat('%', :query, '%')) " +
            "OR s.phoneNumber LIKE concat(:query, '%')")
    List<Supplier> searchByNameOrPhone(@Param("query") String query);
}
