package com.kolbasov.Task2.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;


@Entity
public class Attrection {
    @Id
    @GeneratedValue()
    private UUID id;
    private  String name;
    private  String description;

    private AttractiontType attractiontType;

}
