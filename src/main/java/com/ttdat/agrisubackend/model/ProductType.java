package com.ttdat.agrisubackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import java.util.Set;


@Data
@Entity(name = "product_types")
public class ProductType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Integer productTypeId;

    private String productTypeName;

    @OneToMany(mappedBy = "productType")
    private Set<Product> products;
}
