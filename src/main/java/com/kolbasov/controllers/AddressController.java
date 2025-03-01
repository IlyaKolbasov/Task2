package com.kolbasov.controllers;

import com.kolbasov.dto.AddressDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class AddressController {

   // private final AddressService addressService;
    @PostMapping("/save")
    public ResponseEntity<Map<String,String>> saveAttraction(@RequestBody AddressDto addressDto) {
       // addressService.createAddress(addressDto);
        return ResponseEntity.ok(Collections.singletonMap("message", "Transaction saved successfully"));
        }
    }
