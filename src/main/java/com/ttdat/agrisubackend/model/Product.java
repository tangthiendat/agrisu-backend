package com.ttdat.agrisubackend.model;


import com.ttdat.agrisubackend.util.StringPrefixedIdGenerator;
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
                    @Parameter(name = StringPrefixedIdGenerator.VALUE_PREFIX_PARAMETER, value = "SP"),
                    @Parameter(name = StringPrefixedIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    private String productId;

    private String productName;

    private int stockQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id", referencedColumnName = "productTypeId")
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    private Set<ProductUnit> productUnits;
}
