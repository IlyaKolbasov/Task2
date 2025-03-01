package com.kolbasov.controllers;

import com.kolbasov.dto.AttractionDto;
import com.kolbasov.services.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/attractions")
public class AttractionController {
    @Autowired
    private AttractionService attractionService;
    @PostMapping("/save")
    public ResponseEntity<Map<String,String>> saveAttraction(@RequestBody AttractionDto attractionDto) {
        attractionService.createAttraction(attractionDto);

        return ResponseEntity.ok(Collections.singletonMap("message", "Transaction saved successfully"));
    }
}
