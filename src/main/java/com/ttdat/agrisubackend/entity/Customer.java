package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
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
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private BigDecimal receivable;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
