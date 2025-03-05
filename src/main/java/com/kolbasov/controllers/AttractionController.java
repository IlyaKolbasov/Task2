package com.kolbasov.controllers;

import com.kolbasov.dto.AttractionDto;
import com.kolbasov.services.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AttractionController {
    private final AttractionService attractionService;

    @PostMapping("/create")
    public ResponseEntity<AttractionDto> createAttraction(@RequestBody AttractionDto attractionDto) {

        return ResponseEntity.ok(attractionService.createAttraction(attractionDto));

    }

    @GetMapping("/get")
    public ResponseEntity<List<AttractionDto>> getAllAttractions() {
        return ResponseEntity.ok(attractionService.getAllAttractions());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AttractionDto> getAttraction(@PathVariable UUID id) {
        return ResponseEntity.ok(attractionService.getAttraction(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AttractionDto> updateAttraction(@PathVariable UUID id, @RequestBody AttractionDto attractionDto) {
        return ResponseEntity.ok(attractionService.updateAttraction(id, attractionDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable UUID id) {
        attractionService.deleteAttraction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllAttractions() {
        attractionService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<AttractionDto>> getAttractionsByCity(@PathVariable String city) {

        return ResponseEntity.ok(attractionService.getAttractionsByCity(city));
    }


    @GetMapping("/region/{region}")
    public ResponseEntity<List<AttractionDto>> getAttractionsByRegion(@PathVariable String region) {

        return ResponseEntity.ok(attractionService.getAttractionsByRegion(region));
    }

    @GetMapping("/service/{serviceName}")
    public ResponseEntity<List<AttractionDto>> getAttractionsByServices(@PathVariable String serviceName) {
        return ResponseEntity.ok(attractionService.getAttractionsByServices(serviceName));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AttractionDto>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(attractionService.searchByName(name));
    }

}
