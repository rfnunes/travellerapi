package com.travellerapi.model.mapper;

import com.travellerapi.dto.DocumentDto;
import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.Document;
import com.travellerapi.model.DocumentId;
import com.travellerapi.model.DocumentType;
import com.travellerapi.model.Traveller;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TravellerMapperTest {

    private static final String FIRST_NAME = "John";

    private static final String LAST_NAME = "Doe";

    private static final Date BIRTH_DATE = new Date(0L);

    private static final String EMAIL_ADDRESS = "john.doe@mailserver.org";

    private static final String MOBILE_NUMBER = "+00010000111";

    private static final Document DOCUMENT = new Document();

    private static final DocumentType DOCUMENT_TYPE = DocumentType.ID_CARD;

    private static final String DOCUMENT_NUMBER = "9999";

    private static final String COUNTRY = "US";

    static {
        DocumentId documentId = new DocumentId();
        documentId.setDocumentType(DOCUMENT_TYPE);
        documentId.setNumber(DOCUMENT_NUMBER);
        documentId.setCountry(COUNTRY);
        DOCUMENT.setDocumentId(documentId);
    }
    
    @Test
    void toDto() {
        final Traveller traveller = new Traveller();
        traveller.setFirstName(FIRST_NAME);
        traveller.setLastName(LAST_NAME);
        traveller.setBirthDate(BIRTH_DATE);
        traveller.setEmailAddress(EMAIL_ADDRESS);
        traveller.setMobileNumber(MOBILE_NUMBER);
        traveller.setDocumentSet(Set.of(DOCUMENT));

        final TravellerDto travellerDto = TravellerMapper.toDto(traveller);

        final DocumentDto documentDto = travellerDto.getDocumentDtoSet().iterator().next();

        assertAll(
                () -> assertEquals(FIRST_NAME, travellerDto.getFirstName()),
                () -> assertEquals(LAST_NAME, travellerDto.getLastName()),
                () -> assertEquals(BIRTH_DATE, travellerDto.getBirthDate()),
                () -> assertEquals(EMAIL_ADDRESS, travellerDto.getEmailAddress()),
                () -> assertEquals(MOBILE_NUMBER, travellerDto.getMobileNumber()),
                () -> assertEquals(1, travellerDto.getDocumentDtoSet().size()),
                () -> assertEquals(DOCUMENT_TYPE, documentDto.documentType()),
                () -> assertEquals(DOCUMENT_NUMBER, documentDto.number()),
                () -> assertEquals(COUNTRY, documentDto.issuingCountry())
        );
    }

    @Test
    void toEntity() {

        final TravellerDto travellerDto =
                new TravellerDto(0L,
                                 FIRST_NAME,
                                 LAST_NAME,
                                 BIRTH_DATE,
                                 EMAIL_ADDRESS,
                                 MOBILE_NUMBER,
                                 Set.of(new DocumentDto(DOCUMENT_TYPE, DOCUMENT_NUMBER, COUNTRY, false)));

        final Traveller traveller = TravellerMapper.toEntity(travellerDto);

        assertAll(
                () -> assertEquals(FIRST_NAME, traveller.getFirstName()),
                () -> assertEquals(LAST_NAME, traveller.getLastName()),
                () -> assertEquals(BIRTH_DATE, traveller.getBirthDate()),
                () -> assertEquals(EMAIL_ADDRESS, traveller.getEmailAddress()),
                () -> assertEquals(MOBILE_NUMBER, traveller.getMobileNumber()),
                () -> assertEquals(DOCUMENT, traveller.getDocumentSet().iterator().next())
        );
    }
}