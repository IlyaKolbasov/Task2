package com.kolbasov.repositories;

import com.kolbasov.models.Attraction;
import com.kolbasov.models.Service;
import com.kolbasov.models.ServiceType;
import com.kolbasov.models.TicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketInfoRepository extends JpaRepository<TicketInfo, UUID> {
    Optional<TicketInfo> findByPriceAndCurrencyAndAvailability(BigDecimal price, String currency, Boolean availability);
}
