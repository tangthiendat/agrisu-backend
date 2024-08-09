package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
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
    String paymentId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

    BigDecimal supplierCurrentDebt;

    BigDecimal paidAmount;

    BigDecimal supplierNextDebt;
}
