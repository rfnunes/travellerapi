package com.travellerapi.model.mapper;

import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.Traveller;

public final class TravellerMapper {

    //Suppress default constructor for noninstantiability
    private TravellerMapper() {
        throw new AssertionError("TravellerMapper cannot be instantiated.");
    }

    public static TravellerDto toDto(final Traveller traveller) {
        return new TravellerDto(traveller.getId(),
                                traveller.getFirstName(),
                                traveller.getLastName(),
                                traveller.getBirthDate(),
                                traveller.getEmailAddress(),
                                traveller.getMobileNumber(),
                                null); //FIXME
    }

    public static Traveller toEntity(final TravellerDto travellerDto) {
        final Traveller traveller = new Traveller();

        traveller.setFirstName(travellerDto.getFirstName());
        traveller.setLastName(travellerDto.getLastName());
        traveller.setBirthDate(travellerDto.getBirthDate());
        traveller.setEmailAddress(travellerDto.getEmailAddress());
        traveller.setMobileNumber(travellerDto.getMobileNumber());
        //TODO add documents

        return traveller;
    }
}
