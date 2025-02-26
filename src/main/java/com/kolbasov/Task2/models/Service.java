package com.kolbasov.Task2.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    @ManyToMany(mappedBy = "services")
    private List<Attraction> attractions;

}
