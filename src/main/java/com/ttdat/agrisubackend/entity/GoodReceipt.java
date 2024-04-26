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
@Table(name = "good_receipts")
public class GoodReceipt extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "good_receipt_id_generator")
    @GenericGenerator(
            name = "good_receipt_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @Parameter(name = "sequenceName", value = "good_receipt_id_seq"),
                    @Parameter(name = "prefixValue", value = "N"),
                    @Parameter(name = "numberFormat", value = "%06d"),
                    @Parameter(name = "hasYearPrefix", value = "true")
            }
    )
    private String goodReceiptId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private BigDecimal totalValue;

    private BigDecimal supplierCurrentDebt;

    private BigDecimal supplierNextDebt;

    @OneToMany(mappedBy = "goodReceipt")
    private Set<GoodReceiptDetail> goodReceiptDetails;
}