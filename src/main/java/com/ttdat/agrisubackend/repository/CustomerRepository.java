package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.dto.CustomerHistory;
import com.ttdat.agrisubackend.dto.CustomersSummary;
import com.ttdat.agrisubackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT c FROM Customer c WHERE lower(c.customerName) LIKE lower(concat('%', :query, '%')) " +
            "OR c.phoneNumber LIKE concat(:query, '%')")
    List<Customer> searchByNameOrPhone(@Param("query") String query);

    @Query("SELECT SUM(o.totalValue) FROM Customer c JOIN c.orders o WHERE c.customerId = :customerId")
    BigDecimal findTotalSalesByCustomerId(@Param("customerId") String customerId);

    @Query("SELECT new com.ttdat.agrisubackend.dto.CustomersSummary(SUM(c.receivable), SUM(o.totalValue)) " +
            "FROM Customer c JOIN c.orders o")
    CustomersSummary getCustomersSummary();


}
