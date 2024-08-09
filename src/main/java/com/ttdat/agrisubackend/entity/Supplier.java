package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "suppliers")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supplier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "supplier_id_generator")
    @GenericGenerator(
            name = "supplier_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequenceName", value = "supplier_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "prefixValue", value = "NCC"),
                    @org.hibernate.annotations.Parameter(name = "numberFormat", value = "%05d")
            }
    )
    private String supplierId;

    private String supplierName;

    private String address;

    private String phoneNumber;

    private String taxCode;

    private BigDecimal payable;

    private boolean isDeleted;

}