package com.ttdat.agrisubackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDTO {
    String orderId;
    LocalDateTime createdAt;
    CustomerDTO customer;
    BigDecimal totalValue;
    BigDecimal customerPayment;
    Set<OrderDetailDTO> orderDetails;
}
