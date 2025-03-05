package com.kolbasov.dto;

import com.kolbasov.models.AttractionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDto {
    private UUID id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private AttractionType attractionType;
    private AddressDto address;
    private TicketInfoDto ticketInfo;
    private List<ServiceDto> services;
}

