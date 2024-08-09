package com.ttdat.agrisubackend.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Set;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_id_generator")
    @GenericGenerator(
            name = "product_id_generator",
            strategy = "com.ttdat.agrisubackend.util.StringPrefixedIdGenerator",
            parameters = {
                    @Parameter(name = "sequenceName", value = "product_id_seq"),
                    @Parameter(name = "prefixValue", value = "SP"),
                    @Parameter(name = "numberFormat", value = "%05d")
            }
    )
    String productId;

    String productName;

    int stockQuantity;
    

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    Set<ProductUnit> productUnits;
}
