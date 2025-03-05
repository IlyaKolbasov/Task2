package com.kolbasov.repositories;

import com.kolbasov.models.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, UUID> {
    List<Attraction> findByAddressCity(String city);

    List<Attraction> findByAddressRegion(String region);

    List<Attraction> findByServicesName(String serviceName);

    List<Attraction> findByNameContaining(String name);
}
