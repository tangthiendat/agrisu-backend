package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "warehouse_export_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseExportDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    Long id;

    @ManyToOne
    @JoinColumn(name = "warehouse_export_id", nullable = false)
    WarehouseExport warehouseExport;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    Unit unit;

    Integer quantity;

    BigDecimal unitPrice;

}
