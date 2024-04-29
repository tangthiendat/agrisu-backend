package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_id_generator")
    @GenericGenerator(
            name = "payment_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @Parameter(name = "sequenceName", value = "payment_id_seq"),
                    @Parameter(name = "prefixValue", value = "C"),
                    @Parameter(name = "numberFormat", value = "%06d"),
                    @Parameter(name = "hasYearPrefix", value = "true")
            }
    )
    private String paymentId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private BigDecimal supplierCurrentDebt;

    private BigDecimal paidAmount;

    private BigDecimal supplierNextDebt;
}
