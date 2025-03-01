package com.kolbasov.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfoDto {
    private BigDecimal price;
    private String currency;
    private Boolean availability;
}
