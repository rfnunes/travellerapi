package com.travellerapi.service;

import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.DocumentType;

import java.util.Optional;

public interface ITravellerService {
    TravellerDto createTraveller(TravellerDto travellerDto);

    Optional<TravellerDto> getTraveller(long id);

    Optional<TravellerDto> getTravellerByEmail(String email);

    Optional<TravellerDto> getTravellerByMobile(String mobile);

    Optional<TravellerDto> getTravellerByDocument(DocumentType documentType, String number, String country);

    TravellerDto updateTraveller(TravellerDto travellerDto);

    boolean deactivateTraveller(long id);
}
