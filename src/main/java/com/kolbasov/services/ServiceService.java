package com.kolbasov.services;

import com.kolbasov.dto.ServiceDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kolbasov.mappers.ServiceMapper;
import com.kolbasov.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;


    public ServiceDto createService(ServiceDto serviceDto) {

        if (serviceRepository.findByNameAndServiceType(serviceDto.getName(), serviceDto.getServiceType()).isPresent()) {
            throw new IllegalArgumentException("Service already exists");
        }
        com.kolbasov.models.Service service = serviceMapper.toEntity(serviceDto);
        return serviceMapper.toDto(serviceRepository.save(service));
    }

    public List<ServiceDto> getAllServices() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toDto)
                .collect(Collectors.toList());
    }

    public ServiceDto getService(UUID id) {
        com.kolbasov.models.Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Service not found"));
        return serviceMapper.toDto(service);
    }


    public ServiceDto updateService(UUID id, ServiceDto serviceDto) {
        com.kolbasov.models.Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Service not found"));

        service.setName(serviceDto.getName());
        service.setDescription(serviceDto.getDescription());
        service.setServiceType(serviceDto.getServiceType());

        return serviceMapper.toDto(serviceRepository.save(service));
    }

    public void deleteService(UUID id) {
        if (!serviceRepository.existsById(id)) {
            throw new NoSuchElementException("Service not found");
        }
        serviceRepository.deleteById(id);
    }

    public void deleteAll() {
        serviceRepository.deleteAll();
    }
}