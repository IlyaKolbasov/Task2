package com.kolbasov.controllers;

import com.kolbasov.dto.AttractionDto;
import com.kolbasov.services.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AttractionController {
    private final AttractionService attractionService;

    @PostMapping("/create")
    public ResponseEntity<AttractionDto> createAttraction(@RequestBody AttractionDto attractionDto) {

        return new ResponseEntity<>(attractionService.createAttraction(attractionDto), HttpStatus.CREATED);

    }

    @GetMapping("/get")
    public ResponseEntity<List<AttractionDto>> getAllAttractions() {
        return ResponseEntity.ok(attractionService.getAllAttractions());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AttractionDto> getAttraction(@PathVariable UUID id) {
        return new ResponseEntity<>(attractionService.getAttraction(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AttractionDto> updateAttraction(@PathVariable UUID id, @RequestBody AttractionDto attractionDto) {
        return new ResponseEntity<>(attractionService.updateAttraction(id, attractionDto), HttpStatus.OK);
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

}
