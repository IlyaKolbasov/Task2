package com.kolbasov.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private UUID id;
    private Integer building;
    private String street;
    private String city;
    private String region;
}

