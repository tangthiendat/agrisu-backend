package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductUnitRepository extends JpaRepository<ProductUnit, Integer> {
//    Optional<Set<ProductUnit>> findByProduct_ProductId(String productId);
//    //write custom query to find product units by product id
//    @Query("SELECT pu FROM ProductUnit pu WHERE pu.product.productId = :productId")
//    Optional<Set<ProductUnit>> findByProductId(String productId);
}
