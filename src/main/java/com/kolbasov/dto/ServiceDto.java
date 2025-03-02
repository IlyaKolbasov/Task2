package com.kolbasov.dto;

import com.kolbasov.models.ServiceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private UUID id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
}