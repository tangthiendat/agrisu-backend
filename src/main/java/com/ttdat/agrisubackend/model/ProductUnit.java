package com.ttdat.agrisubackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products_units")
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unitId", nullable = false)
    private Unit unit;

    private Integer baseQuantity;

    @Column(precision = 15, scale = 2)
    private BigDecimal originalPrice;

    @Column(precision = 15, scale = 2)
    private BigDecimal sellingPrice;

    private boolean isDefault;

}
