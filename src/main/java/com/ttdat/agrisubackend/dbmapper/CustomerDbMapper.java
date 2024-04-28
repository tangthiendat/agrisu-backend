package com.ttdat.agrisubackend.dbmapper;

import com.ttdat.agrisubackend.dto.CustomerHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface CustomerDbMapper {
    @Select("""
            SELECT we.warehouse_export_id as id, we.created_at as createdAt, 'WAREHOUSE_EXPORT' as type,
            we.customer_current_debt as currentDebt, we.total_value as value, 0 as payment, we.customer_next_debt as nextDebt
            FROM warehouse_exports we
            WHERE we.customer_id = #{customerId}
            UNION
            SELECT r.receipt_id as id, r.created_at as createdAt, 'RECEIPT' as type, 
            r.customer_current_debt as currentDebt, 0 as value, r.paid_amount as payment, r.customer_next_debt as nextDebt
            FROM receipts r
            WHERE r.customer_id = #{customerId}
            ORDER BY createdAt DESC
            """)
    List<CustomerHistory> getCustomerHistory(@Param("customerId") String customerId);
}
