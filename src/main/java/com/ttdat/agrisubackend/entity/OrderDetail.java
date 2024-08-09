package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unitId")
    Unit unit;

    BigDecimal unitPrice;

    Integer quantity;

}
