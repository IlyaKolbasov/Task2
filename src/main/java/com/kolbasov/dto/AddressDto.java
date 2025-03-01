package com.kolbasov.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer building;
    private String street;
    private String city;
    private String region;
}

