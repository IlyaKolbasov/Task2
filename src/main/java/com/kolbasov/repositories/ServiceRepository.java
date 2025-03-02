package com.kolbasov.repositories;


import com.kolbasov.models.Address;
import com.kolbasov.models.Service;
import com.kolbasov.models.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ServiceRepository extends JpaRepository<Service, UUID> {
    Optional<Service> findByNameAndServiceType(String name, ServiceType serviceType);

}
