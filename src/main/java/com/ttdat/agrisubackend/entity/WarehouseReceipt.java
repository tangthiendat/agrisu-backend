package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "warehouse_receipts")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseReceipt extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "warehouse_receipt_id_generator")
    @GenericGenerator(
            name = "warehouse_receipt_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @Parameter(name = "sequenceName", value = "warehouse_receipt_id_seq"),
                    @Parameter(name = "prefixValue", value = "N"),
                    @Parameter(name = "numberFormat", value = "%06d"),
                    @Parameter(name = "hasYearPrefix", value = "true")
            }
    )
    String warehouseReceiptId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

    BigDecimal totalValue;

    BigDecimal supplierCurrentDebt;

    BigDecimal supplierNextDebt;

    @OneToMany(mappedBy = "warehouseReceipt")
    Set<WarehouseReceiptDetail> warehouseReceiptDetails;
}