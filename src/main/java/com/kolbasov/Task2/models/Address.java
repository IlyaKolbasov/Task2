package com.kolbasov.Task2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Address {
    @Id
    private UUID id;
    private Integer building;
    private String street;
    private String city;
    private String region;
}
