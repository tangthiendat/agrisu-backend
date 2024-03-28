package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.model.Product;
import com.ttdat.agrisubackend.model.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ProductUnitRepository extends JpaRepository<ProductUnit, Integer> {
    Optional<Set<ProductUnit>> findByProduct(Product product);
}
