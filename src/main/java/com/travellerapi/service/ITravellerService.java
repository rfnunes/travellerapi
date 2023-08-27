package com.travellerapi.service;

import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.DocumentType;

public interface ITravellerService {
    TravellerDto createTraveller(TravellerDto travellerDto);

    TravellerDto getTraveller(long id);

    TravellerDto getTravellerByEmail(String email);

    TravellerDto getTravellerByMobile(String mobile);

    TravellerDto getTravellerByDocument(DocumentType documentType, String number, String country);

    boolean updateTraveller(TravellerDto travellerDto);

    boolean deactivateTraveller(long id);
}
