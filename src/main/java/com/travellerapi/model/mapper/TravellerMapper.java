package com.travellerapi.model.mapper;

import com.travellerapi.dto.DocumentDto;
import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.Traveller;

import java.util.Set;
import java.util.stream.Collectors;

public final class TravellerMapper {

    //Suppress default constructor for noninstantiability
    private TravellerMapper() {
        throw new AssertionError("TravellerMapper cannot be instantiated.");
    }

    public static TravellerDto toDto(final Traveller traveller) {

        final Set<DocumentDto> documentDtoSet =
                traveller.getDocumentSet()
                         .stream()
                         .map(DocumentMapper::toDto)
                         .collect(Collectors.toSet());

        return new TravellerDto(traveller.getId(),
                                traveller.getFirstName(),
                                traveller.getLastName(),
                                traveller.getBirthDate(),
                                traveller.getEmailAddress(),
                                traveller.getMobileNumber(),
                                documentDtoSet);
    }

    public static Traveller toEntity(final TravellerDto travellerDto) {
        final Traveller traveller = new Traveller();

        traveller.setFirstName(travellerDto.getFirstName());
        traveller.setLastName(travellerDto.getLastName());
        traveller.setBirthDate(travellerDto.getBirthDate());
        traveller.setEmailAddress(travellerDto.getEmailAddress());
        traveller.setMobileNumber(travellerDto.getMobileNumber());
        traveller.setDocumentSet(travellerDto.getDocumentDtoSet()
                                             .stream()
                                             .map(DocumentMapper::toEntity)
                                             .collect(Collectors.toSet()));
        return traveller;
    }
}
