package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;

@Entity
@Table(name = "receipts")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
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
    String receiptId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    BigDecimal customerCurrentDebt;

    BigDecimal paidAmount;

    BigDecimal customerNextDebt;

}