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

    public List<AttractionDto> getAttractionsByCity(String city) {
        List<Attraction> attractions = attractionRepository.findByAddressCity(city);
        if (attractions.isEmpty()) {
            throw new NoSuchElementException("No attractions found in city: " + city);
        }
        return attractions.stream()
                .map(attractionMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<AttractionDto> getAttractionsByRegion(String region) {
        List<Attraction> attractions = attractionRepository.findByAddressRegion(region);
        if (attractions.isEmpty()) {
            throw new NoSuchElementException("No attractions found in region: " + region);
        }
        return attractions.stream()
                .map(attractionMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<AttractionDto> getAttractionsByServices(String serviceName) {
        List<Attraction> attractions = attractionRepository.findByServicesName(serviceName);
        if (attractions.isEmpty()) {
            throw new NoSuchElementException("No attractions found with service: " + serviceName);
        }
        return attractions.stream()
                .map(attractionMapper::toDto)
                .collect(Collectors.toList());

    }

    public List<AttractionDto> searchByName(String name) {
        List<Attraction> attractions = attractionRepository.findByNameContaining(name);
            if (attractions.isEmpty()) {
                throw new NoSuchElementException("No attractions found with name containing: " + name);
            }
        return attractions.stream()
                .map(attractionMapper::toDto)
                .collect(Collectors.toList());
    }
}
