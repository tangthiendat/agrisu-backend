package com.ttdat.agrisubackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ttdat.agrisubackend.model.Product;
import com.ttdat.agrisubackend.model.Unit;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUnitDTO {
    private Integer id;
    private UnitDTO unit;
    private Integer baseQuantity;
    private BigDecimal originalPrice;
    private BigDecimal sellingPrice;
}
