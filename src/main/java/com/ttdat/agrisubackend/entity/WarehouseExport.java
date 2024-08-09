package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "warehouse_exports")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseExport extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "warehouse_export_id_generator")
    @GenericGenerator(
            name = "warehouse_export_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @Parameter(name = "sequenceName", value = "warehouse_export_id_seq"),
                    @Parameter(name = "prefixValue", value = "X"),
                    @Parameter(name = "numberFormat", value = "%06d"),
                    @Parameter(name = "hasYearPrefix", value = "true")
            }
    )
    String warehouseExportId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    BigDecimal totalValue;

    BigDecimal customerCurrentDebt;

    BigDecimal customerNextDebt;

    @OneToMany(mappedBy = "warehouseExport")
    Set<WarehouseExportDetail> warehouseExportDetails;
}
