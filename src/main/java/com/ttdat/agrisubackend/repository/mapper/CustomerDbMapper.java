package com.ttdat.agrisubackend.repository.mapper;

import com.ttdat.agrisubackend.dto.CustomerHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface CustomerDbMapper {
    @Select("""
            SELECT o.order_id as id, o.created_at as createdAt, 'Mua hàng' as type, o.total_value as value, o.customer_next_debt as nextDebt
            FROM orders o
            WHERE o.customer_id = #{customerId}
            UNION
            SELECT r.receipt_id as id, r.created_at as createdAt, 'Thanh toán' as type, (r.paid_amount * -1) as value, r.customer_next_debt as nextDebt
            FROM receipts r
            WHERE r.customer_id = #{customerId}
            ORDER BY createdAt DESC
            """)
    List<CustomerHistory> getCustomerHistory(@Param("customerId") String customerId);
}
