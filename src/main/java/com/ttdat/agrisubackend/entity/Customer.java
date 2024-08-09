package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_id_generator")
    @GenericGenerator(
            name = "customer_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequenceName", value = "customer_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "prefixValue", value = "KH"),
                    @org.hibernate.annotations.Parameter(name = "numberFormat", value = "%06d")
            }
    )
    String customerId;

    String customerName;

    String phoneNumber;

    String address;

    BigDecimal receivable;

    String taxCode;

    @Column(name = "is_deleted")
    boolean isDeleted;

    @OneToMany(mappedBy = "customer")
    Set<Order> orders;

    @OneToMany(mappedBy = "customer")
    Set<Receipt> receipts;
}
