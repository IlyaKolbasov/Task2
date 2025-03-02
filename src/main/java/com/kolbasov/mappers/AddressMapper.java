package com.kolbasov.mappers;

import com.kolbasov.dto.AddressDto;
import com.kolbasov.models.Address;

public class AddressMapper {
    public AddressDto toDto(Address address) {
        if (address == null) {
            return null;
        }
        return AddressDto.builder()
                .id(address.getId())
                .building(address.getBuilding())
                .street(address.getStreet())
                .city(address.getCity())
                .region(address.getRegion())
                .build();
    }
    public Address toEntity(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        return Address.builder()
                .building(addressDto.getBuilding())
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .region(addressDto.getRegion())
                .build();
    }
}
