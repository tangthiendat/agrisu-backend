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
@Table(name = "receipts")
public class Receipt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "receipt_id_generator")
    @GenericGenerator(
            name = "receipt_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @Parameter(name = "sequenceName", value = "receipt_id_seq"),
                    @Parameter(name = "prefixValue", value = "T"),
                    @Parameter(name = "numberFormat", value = "%06d"),
                    @Parameter(name = "hasYearPrefix", value = "true")
            }
    )
    private String receiptId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private BigDecimal customerCurrentDebt;

    private BigDecimal paidAmount;

    private BigDecimal customerNextDebt;

}