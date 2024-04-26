package com.ttdat.agrisubackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "good_receipt_details")
public class GoodReceiptDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "good_receipt_id", nullable = false)
    private GoodReceipt goodReceipt;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    private Integer quantity;

    private BigDecimal unitPrice;

}