package com.kolbasov.mappers;

import com.kolbasov.dto.AttractionDto;
import com.kolbasov.models.Attraction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AttractionMapper {
    private final AddressMapper addressMapper;
    private final TicketInfoMapper ticketInfoMapper;
    private final ServiceMapper serviceMapper;

    public AttractionDto toDto(Attraction attraction) {
        if (attraction == null) {
            throw new IllegalArgumentException("Attraction is null in Mapper");
        }
        return AttractionDto.builder()
                .id(attraction.getId())
                .name(attraction.getName())
                .description(attraction.getDescription())
                .attractionType(attraction.getAttractionType())
                .address(attraction.getAddress() != null ? addressMapper.toDto(attraction.getAddress()) : null)
                .ticketInfo(attraction.getTicketInfo() != null ? ticketInfoMapper.toDto(attraction.getTicketInfo()) : null)
                .services(attraction.getServices().stream()
                        .map(serviceMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public Attraction toEntity(AttractionDto attractionDto) {
        if (attractionDto == null) {
            throw new IllegalArgumentException("AttractionDto is null in Mapper");
        }
        return Attraction.builder()
                .name(attractionDto.getName())
                .description(attractionDto.getDescription())
                .attractionType(attractionDto.getAttractionType())
                .address(addressMapper.toEntity(attractionDto.getAddress())) // Преобразование адреса
                .ticketInfo(ticketInfoMapper.toEntity(attractionDto.getTicketInfo())) // Преобразование билетной информации
                .services(attractionDto.getServices().stream()
                        .map(serviceMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
