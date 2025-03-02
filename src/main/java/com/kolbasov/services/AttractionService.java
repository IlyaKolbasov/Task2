package com.kolbasov.services;


import com.kolbasov.dto.AttractionDto;
import com.kolbasov.models.Address;
import com.kolbasov.models.Attraction;
import com.kolbasov.repositories.AddressRepository;
import com.kolbasov.repositories.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionRepository attractionRepository;
    private final AddressRepository addressRepository;

    public void createAttraction(AttractionDto attractionDto) {
        Address address = addressRepository.findByBuildingAndStreetAndCity(
                attractionDto.getAddress().getBuilding(),
                attractionDto.getAddress().getStreet(),
                attractionDto.getAddress().getCity()
        ).orElseGet(() -> Address.builder()
                .building(attractionDto.getAddress().getBuilding())
                .street(attractionDto.getAddress().getStreet())
                .city(attractionDto.getAddress().getCity())
                .region(attractionDto.getAddress().getRegion())
                .build());
        attractionRepository.save(
                Attraction.builder()
                        .name(attractionDto.getName())
                        .description(attractionDto.getDescription())
                        .attractiontType(attractionDto.getAttractiontType())
                        .address(address)
                        .build());
    }
}
