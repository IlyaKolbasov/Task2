package com.kolbasov.Task2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class TicketInfo {
    @Id
    private UUID id;
    private BigDecimal price;
    private String currency;
    private boolean availability;
}
