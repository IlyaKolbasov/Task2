package com.kolbasov.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_info")
public class TicketInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "currency")
    private String currency;
    @Column(name = "availability")
    private Boolean availability;
    @OneToOne(mappedBy = "ticketInfo")
    private Attraction attraction;
}
