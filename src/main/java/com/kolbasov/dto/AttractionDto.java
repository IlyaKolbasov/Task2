package com.kolbasov.dto;

import com.kolbasov.models.AttractiontType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDto {
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private AttractiontType attractiontType;
    private AddressDto address;
    private TicketInfoDto ticketInfo;
    private List<ServiceDto> services;
}

