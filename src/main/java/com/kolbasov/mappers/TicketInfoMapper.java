package com.kolbasov.mappers;

import com.kolbasov.dto.TicketInfoDto;
import com.kolbasov.models.TicketInfo;
import org.springframework.stereotype.Component;

@Component
public class TicketInfoMapper {

    public TicketInfoDto toDto(TicketInfo ticketInfo) {
        if (ticketInfo == null) {
            throw new IllegalArgumentException("TicketInfo cannot be null");
        }
        return TicketInfoDto.builder()
                .id(ticketInfo.getId())
                .price(ticketInfo.getPrice())
                .currency(ticketInfo.getCurrency())
                .availability(ticketInfo.getAvailability())
                .build();
    }

    public TicketInfo toEntity(TicketInfoDto ticketInfoDto) {
        if (ticketInfoDto == null) {
            throw new IllegalArgumentException("TicketInfoDto cannot be null");
        }
        return TicketInfo.builder()
                .price(ticketInfoDto.getPrice())
                .currency(ticketInfoDto.getCurrency())
                .availability(ticketInfoDto.getAvailability())
                .build();
    }
}
