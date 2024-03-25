package com.ttdat.agrisubackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
@Table(name = "units")
public class Unit extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native")
    private Integer unitId;

    private String unitName;

    @OneToMany(mappedBy = "unit")
    private Set<ProductUnit> productUnits;
}
