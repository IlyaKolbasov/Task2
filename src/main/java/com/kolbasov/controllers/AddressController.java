package com.kolbasov.controllers;

import com.kolbasov.dto.AddressDto;

import com.kolbasov.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<AddressDto> createAttraction(@RequestBody AddressDto addressDto) {

        return ResponseEntity.ok(addressService.createAddress(addressDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {

        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable UUID id) {
        return ResponseEntity.ok(addressService.getAddress(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable UUID id, @RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.updateAddress(id, addressDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAll() {
        addressService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
