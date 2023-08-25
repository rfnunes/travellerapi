package com.travellerapi.service;

import com.travellerapi.dto.DocumentType;
import com.travellerapi.dto.Traveller;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TravellerService {

    private static final Traveller TRAVELLER = new Traveller(0L,
                                                             "Ricardo",
                                                             "Nunes",
                                                             "07/05/1978",
                                                             "email@mail.com",
                                                             "+351123456789",
                                                             Collections.emptySet());

    public Traveller createTraveller(final Traveller traveller) {
        return TRAVELLER.withId(1L);
    }

    public Traveller getTraveller(long id) {
        if (TRAVELLER.id() == id) {
            return TRAVELLER;
        }
        return null;
    }

    public Traveller getTravellerByEmail(String email) {
        if (TRAVELLER.emailAddress().equalsIgnoreCase(email)) {
            return TRAVELLER;
        }
        return null;
    }

    public Traveller getTravellerByMobile(String mobile) {
        if (TRAVELLER.mobileNumber().equals(mobile)) {
            return TRAVELLER;
        }
        return null;
    }

    public Traveller getTravellerByDocument(DocumentType documentType, String number, String country) {
        return null;
    }

    public boolean updateTraveller(Traveller traveller) {
        return true;
    }

    public boolean deactivateTraveller(long id) {
        return true;
    }
}
