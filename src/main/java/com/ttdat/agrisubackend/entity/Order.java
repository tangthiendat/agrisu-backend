package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id_generator")
    @GenericGenerator(
            name = "order_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @Parameter(name = "sequenceName", value = "order_id_seq"),
                    @Parameter(name = "prefixValue", value = "HD"),
                    @Parameter(name = "numberFormat", value = "%06d")
            }
    )
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    private BigDecimal totalValue;

    private boolean isPaid;

    private BigDecimal customerPayment;

    private BigDecimal customerNextDebt;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
}
