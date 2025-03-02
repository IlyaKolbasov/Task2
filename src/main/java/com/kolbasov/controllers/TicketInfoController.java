package com.kolbasov.controllers;

import com.kolbasov.dto.TicketInfoDto;
import com.kolbasov.services.TicketInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ticket-info")
@RequiredArgsConstructor
public class TicketInfoController {

    private final TicketInfoService ticketInfoService;


    @PostMapping("/create")
    public ResponseEntity<TicketInfoDto> createTicketInfo(@RequestBody TicketInfoDto ticketInfoDto) {
        return new ResponseEntity<>(ticketInfoService.createTicketInfo(ticketInfoDto), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TicketInfoDto>> getAllTicketInfo() {
        return ResponseEntity.ok(ticketInfoService.getAllTicketInfo());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TicketInfoDto> getTicketInfo(@PathVariable UUID id) {
        return ResponseEntity.ok(ticketInfoService.getTicketInfo(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<TicketInfoDto> updateTicketInfo(@PathVariable UUID id, @RequestBody TicketInfoDto ticketInfoDto) {
        return ResponseEntity.ok(ticketInfoService.updateTicketInfo(id, ticketInfoDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicketInfo(@PathVariable UUID id) {
        ticketInfoService.deleteTicketInfo(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllTicketInfo() {
        ticketInfoService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

