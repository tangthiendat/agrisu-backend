package com.ttdat.agrisubackend.dbmapper;

import com.ttdat.agrisubackend.dto.SupplierHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupplierDbMapper {

    @Select("""
            SELECT wr.warehouse_receipt_id as id, wr.created_at as createdAt, 'WAREHOUSE_RECEIPT' as type,
            wr.supplier_current_debt as currentDebt, wr.total_value as value, 0 as payment, wr.supplier_next_debt as nextDebt
            FROM warehouse_receipts wr
            WHERE wr.supplier_id = #{supplierId}
            UNION
            SELECT p.payment_id as id, p.created_at as createdAt, 'PAYMENT' as type,
            p.supplier_current_debt as currentDebt, 0 as value, p.paid_amount as payment, p.supplier_next_debt as nextDebt
            FROM payments p
            WHERE p.supplier_id = #{supplierId}
            ORDER BY createdAt DESC
            """)
    List<SupplierHistory> getSupplierHistory(String supplierId);
}
