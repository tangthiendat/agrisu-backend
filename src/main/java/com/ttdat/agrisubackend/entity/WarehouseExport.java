package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "warehouse_exports")
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
    private String warehouseExportId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private BigDecimal totalValue;

    private BigDecimal customerCurrentDebt;

    private BigDecimal customerNextDebt;

    @OneToMany(mappedBy = "warehouseExport")
    private Set<WarehouseExportDetail> warehouseExportDetails;
}
