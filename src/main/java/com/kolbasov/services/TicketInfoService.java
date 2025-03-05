package com.kolbasov.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kolbasov.dto.TicketInfoDto;
import com.kolbasov.mappers.TicketInfoMapper;
import com.kolbasov.models.TicketInfo;
import com.kolbasov.repositories.TicketInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketInfoService {
    private final TicketInfoRepository ticketInfoRepository;
    private final TicketInfoMapper ticketInfoMapper;


    public TicketInfoDto createTicketInfo(TicketInfoDto ticketInfoDto) {
        if (ticketInfoRepository.findByPriceAndCurrencyAndAvailability(ticketInfoDto.getPrice(), ticketInfoDto.getCurrency(), ticketInfoDto.getAvailability()).isPresent()) {
            throw new IllegalArgumentException("TicketInfo already exists");
        }
        TicketInfo ticketInfo = ticketInfoMapper.toEntity(ticketInfoDto);
        return ticketInfoMapper.toDto(ticketInfoRepository.save(ticketInfo));
    }

    public List<TicketInfoDto> getAllTicketInfo() {
        return ticketInfoRepository.findAll().stream().map(ticketInfoMapper::toDto).collect(Collectors.toList());
    }

    public TicketInfoDto getTicketInfo(UUID id) {
        TicketInfo ticketInfo = ticketInfoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TicketInfo not found"));
        return ticketInfoMapper.toDto(ticketInfo);
    }

    public TicketInfoDto updateTicketInfo(UUID id, TicketInfoDto ticketInfoDto) {
        TicketInfo ticketInfo = ticketInfoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TicketInfo not found"));

        ticketInfo.setPrice(ticketInfoDto.getPrice());
        ticketInfo.setCurrency(ticketInfoDto.getCurrency());
        ticketInfo.setAvailability(ticketInfoDto.getAvailability());

        return ticketInfoMapper.toDto(ticketInfoRepository.save(ticketInfo));
    }

    public void deleteTicketInfo(UUID id) {
        if (!ticketInfoRepository.existsById(id)) {
            throw new NoSuchElementException("TicketInfo not found");
        }
        ticketInfoRepository.deleteById(id);
    }

    public void deleteAll() {
        ticketInfoRepository.deleteAll();
    }
}
