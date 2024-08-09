package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "products_units")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId", nullable = false)
    Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unitId", nullable = false)
    Unit unit;

    Integer baseQuantity;

    @Column(precision = 15, scale = 2)
    BigDecimal originalPrice;

    @Column(precision = 15, scale = 2)
    BigDecimal sellingPrice;

    boolean isDefault;

}
