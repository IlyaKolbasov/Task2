package com.kolbasov.controllers;

import com.kolbasov.dto.ServiceDto;
import com.kolbasov.services.ServiceService;
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
    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto serviceDto) {

        return new ResponseEntity<>(serviceService.createService(serviceDto), HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ServiceDto> getService(@PathVariable UUID id) {
        return ResponseEntity.ok(serviceService.getService(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceDto> updateService(@PathVariable UUID id, @RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(serviceService.updateService(id, serviceDto));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable UUID id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteAllServices() {
        serviceService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
