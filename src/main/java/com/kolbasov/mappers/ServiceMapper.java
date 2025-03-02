package com.kolbasov.mappers;

import com.kolbasov.dto.ServiceDto;
import com.kolbasov.models.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public ServiceDto toDto(Service service) {
        if (service == null) {
            throw new IllegalArgumentException("Service is null in Mapper");
        }
        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .serviceType(service.getServiceType())
                .build();
    }

    public Service toEntity(ServiceDto serviceDto) {
        if (serviceDto == null) {
            throw new IllegalArgumentException("ServiceDto is null in Mapper");
        }
        return Service.builder()
                .name(serviceDto.getName())
                .description(serviceDto.getDescription())
                .serviceType(serviceDto.getServiceType())
                .build();
    }
}