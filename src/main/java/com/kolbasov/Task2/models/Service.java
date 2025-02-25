package com.kolbasov.Task2.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Service {
    @Id
    private UUID id;
    private String name;
    private String description;
    private ServiceType serviceType;

}
