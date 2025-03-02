package com.kolbasov.mappers;

import com.kolbasov.dto.ServiceDto;
import com.kolbasov.models.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public ServiceDto toDto(Service service) {
        if (service == null) {
            return null;
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
            return null;
        }
        return Service.builder()
                .name(serviceDto.getName())
                .description(serviceDto.getDescription())
                .serviceType(serviceDto.getServiceType())
                .build();
    }
}