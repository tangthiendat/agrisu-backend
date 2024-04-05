package com.ttdat.agrisubackend.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
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
    private String productId;

    private String productName;

    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "productTypeId")
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    private Set<ProductUnit> productUnits;
}
