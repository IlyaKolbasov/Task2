package com.kolbasov.services;


import com.kolbasov.dto.AttractionDto;
import com.kolbasov.mappers.AddressMapper;
import com.kolbasov.mappers.AttractionMapper;
import com.kolbasov.mappers.ServiceMapper;
import com.kolbasov.mappers.TicketInfoMapper;
import com.kolbasov.models.Attraction;

import java.util.List;

import com.kolbasov.models.TicketInfo;
import com.kolbasov.repositories.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper;
    private final AddressMapper addressMapper;
    private final TicketInfoMapper ticketInfoMapper;
    private final ServiceMapper serviceMapper;

    public AttractionDto createAttraction(AttractionDto attractionDto) {
        Attraction attraction = attractionMapper.toEntity(attractionDto);
        return attractionMapper.toDto(attractionRepository.save(attraction));
    }

    public List<AttractionDto> getAllAttractions() {
        return attractionRepository.findAll().stream()
                .map(attractionMapper::toDto)
                .collect(Collectors.toList());
    }

    public AttractionDto getAttraction(UUID id) {
        Attraction attraction = attractionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Attraction not found"));
        return attractionMapper.toDto(attraction);
    }

    public AttractionDto updateAttraction(UUID id, AttractionDto attractionDto) {
        Attraction attraction = attractionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Attraction not found"));

        attraction.setName(attractionDto.getName());
        attraction.setDescription(attractionDto.getDescription());
        attraction.setAttractionType(attractionDto.getAttractionType());
        attraction.setAddress(addressMapper.toEntity(attractionDto.getAddress()));
        attraction.setTicketInfo(ticketInfoMapper.toEntity(attractionDto.getTicketInfo()));
        attraction.setServices(attractionDto.getServices().stream()
                .map(serviceMapper::toEntity)
                .collect(Collectors.toList()));

        return attractionMapper.toDto(attractionRepository.save(attraction));
    }

    public void deleteAttraction(UUID id) {
        if (!attractionRepository.existsById(id)) {
            throw new NoSuchElementException("Attraction not found");
        }
        attractionRepository.deleteById(id);
    }

    public void deleteAll() {
        attractionRepository.deleteAll();
    }

}
