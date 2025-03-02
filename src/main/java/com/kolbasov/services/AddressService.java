package com.kolbasov.services;

import com.kolbasov.dto.AddressDto;
import com.kolbasov.mappers.AddressMapper;
import com.kolbasov.models.Address;
import com.kolbasov.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressDto createAddress(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        return addressMapper.toDto(addressRepository.save(address));
    }

    public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll().stream().map(addressMapper::toDto).collect(Collectors.toList());
    }

    public AddressDto getAddress(UUID id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address not found"));
        return addressMapper.toDto(address);
    }

    public AddressDto updateAddress(UUID id, AddressDto addressDto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address not found"));

        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setRegion(addressDto.getRegion());
        address.setBuilding(addressDto.getBuilding());

        return addressMapper.toDto(addressRepository.save(address));

    }

    public void deleteAddress(UUID id) {
        if (!addressRepository.existsById(id)) {
            throw new NoSuchElementException("Address not found");
        }
        addressRepository.deleteById(id);
    }

    public void deleteAll() {
        addressRepository.deleteAll();
    }

}
