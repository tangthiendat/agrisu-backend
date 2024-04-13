package com.ttdat.agrisubackend.dto;

import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQuery(
        name = "getCustomersSummary",
        procedureName = "get_customers_summary",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "total_receivable", type = BigDecimal.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "total_sales", type = BigDecimal.class)
        }
)
public class CustomersSummary {
    private BigDecimal totalReceivable;
    private BigDecimal totalSales;
}
