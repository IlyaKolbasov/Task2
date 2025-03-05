package com.kolbasov.controllers;

import com.kolbasov.dto.TicketInfoDto;
import com.kolbasov.services.TicketInfoService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create ticketInfo", description = "Creates a new ticketInfo")
    public ResponseEntity<TicketInfoDto> createTicketInfo(@RequestBody TicketInfoDto ticketInfoDto) {
        return ResponseEntity.ok(ticketInfoService.createTicketInfo(ticketInfoDto));
    }

    @GetMapping("/get")
    @Operation(summary = "Get all  ticketInfo", description = "Get all ticketInfo from the database")
    public ResponseEntity<List<TicketInfoDto>> getAllTicketInfo() {
        return ResponseEntity.ok(ticketInfoService.getAllTicketInfo());
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get  ticketInfo", description = "Get  ticketInfo by id from the database")
    public ResponseEntity<TicketInfoDto> getTicketInfo(@PathVariable UUID id) {
        return ResponseEntity.ok(ticketInfoService.getTicketInfo(id));
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Update  ticketInfo", description = "Update  ticketInfo by id")
    public ResponseEntity<TicketInfoDto> updateTicketInfo(@PathVariable UUID id, @RequestBody TicketInfoDto ticketInfoDto) {
        return ResponseEntity.ok(ticketInfoService.updateTicketInfo(id, ticketInfoDto));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete  ticketInfo", description = "Delete  ticketInfo by id from the database")
    public ResponseEntity<Void> deleteTicketInfo(@PathVariable UUID id) {
        ticketInfoService.deleteTicketInfo(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete all  ticketInfo", description = "Delete all  ticketInfo from the database")
    public ResponseEntity<Void> deleteAllTicketInfo() {
        ticketInfoService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

