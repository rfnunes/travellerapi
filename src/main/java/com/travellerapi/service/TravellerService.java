package com.travellerapi.service;

import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.DocumentType;
import com.travellerapi.model.mapper.TravellerMapper;
import com.travellerapi.model.validator.TravellerValidator;
import com.travellerapi.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TravellerService implements ITravellerService {

    @Autowired
    private TravellerRepository travellerRepository;

    private static final TravellerDto TRAVELLER_DTO = new TravellerDto(0L,
                                                                       "Ricardo",
                                                                       "Nunes",
                                                                       "07/05/1978",
                                                                       "email@mail.com",
                                                                       "+351123456789",
                                                                       Collections.emptySet());

    @Override
    public TravellerDto createTraveller(final TravellerDto travellerDto) {
        if(!TravellerValidator.isvalid(travellerDto)) {
            throw new RuntimeException(); //FIXME create a specific exception
        }
        return TravellerMapper.toDto(
                travellerRepository.save(TravellerMapper.toEntity(travellerDto)));
    }

    @Override
    public TravellerDto getTraveller(long id) {
        return travellerRepository.findById(id).map(TravellerMapper::toDto).orElse(null);
    }

    @Override
    public TravellerDto getTravellerByEmail(String email) {
        if (TRAVELLER_DTO.emailAddress().equalsIgnoreCase(email)) {
            return TRAVELLER_DTO;
        }
        return null;
    }

    @Override
    public TravellerDto getTravellerByMobile(String mobile) {
        if (TRAVELLER_DTO.mobileNumber().equals(mobile)) {
            return TRAVELLER_DTO;
        }
        return null;
    }

    @Override
    public TravellerDto getTravellerByDocument(DocumentType documentType, String number, String country) {
        return null;
    }

    @Override
    public boolean updateTraveller(TravellerDto travellerDto) {
        return true;
    }

    @Override
    public boolean deactivateTraveller(long id) {
        return true;
    }
}
