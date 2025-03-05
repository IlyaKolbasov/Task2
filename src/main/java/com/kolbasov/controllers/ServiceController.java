package com.kolbasov.controllers;

import com.kolbasov.dto.ServiceDto;
import com.kolbasov.services.ServiceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @PostMapping("/create")
    @Operation(summary = "Create service", description = "Creates a new service")
    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(serviceService.createService(serviceDto));
    }


    @GetMapping("/get")
    @Operation(summary = "Get all services", description = "Get all services from the database")
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get service", description = "Get services by id from the database")
    public ResponseEntity<ServiceDto> getService(@PathVariable UUID id) {
        return ResponseEntity.ok(serviceService.getService(id));
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Update service", description = "Update service by id")
    public ResponseEntity<ServiceDto> updateService(@PathVariable UUID id, @RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(serviceService.updateService(id, serviceDto));
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete service", description = "Delete service by id from the database")
    public ResponseEntity<Void> deleteService(@PathVariable UUID id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete")
    @Operation(summary = "Delete all services", description = "Delete all services from the database")
    public ResponseEntity<Void> deleteAllServices() {
        serviceService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
