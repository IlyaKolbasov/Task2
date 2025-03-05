package com.kolbasov.models;

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
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "building")
    private Integer building;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @OneToMany(mappedBy = "address")
    private List<Attraction> attractions;
}
