package com.kolbasov.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfoDto {
    private UUID id;
    private BigDecimal price;
    private String currency;
    private Boolean availability;
}
