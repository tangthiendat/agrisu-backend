package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p WHERE lower(p.productName) LIKE lower(concat('%', :query, '%'))")
    List<Product> searchByName(String query);
}
