package com.kolbasov.repository;

import com.kolbasov.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
     Optional<Address> findByBuildingAndStreetAAndCity(Integer building, String street,String city);
}
