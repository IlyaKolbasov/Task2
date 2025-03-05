package com.kolbasov.controllers;

import com.kolbasov.dto.AddressDto;

import com.kolbasov.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.UUID;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    @Operation(summary = "Create address", description = "Creates a new address")
    public ResponseEntity<AddressDto> createAdress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.createAddress(addressDto));
    }

    @GetMapping("/get")
    @Operation(summary = "Get all addresses", description = "Get all addresses from the database")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get address", description = "Get address by id from the database")
    public ResponseEntity<AddressDto> getAddress(@PathVariable UUID id) {
        return ResponseEntity.ok(addressService.getAddress(id));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update address", description = "Update address by id")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable UUID id, @RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.updateAddress(id, addressDto));
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "Delete address", description = "Delete address by id from the database")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    @Operation(summary = "Delete all addresses", description = "Delete all addresses from the database")
    public ResponseEntity<Void> deleteAll() {
        addressService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
