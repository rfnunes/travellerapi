package com.travellerapi.model.mapper;

import com.travellerapi.dto.DocumentDto;
import com.travellerapi.model.Document;
import com.travellerapi.model.DocumentId;
import com.travellerapi.model.DocumentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentMapperTest {

    private static final DocumentType DOCUMENT_TYPE = DocumentType.ID_CARD;

    private static final String NUMBER = "999";

    private static final String COUNTRY = "US";

    @Test
    void toDto() {

        final Document document = new Document();
        document.setDocumentId(DocumentId.of(DOCUMENT_TYPE, NUMBER, COUNTRY));

        final DocumentDto documentDto = DocumentMapper.toDto(document);

        assertAll(
                () -> assertEquals(DOCUMENT_TYPE, documentDto.documentType()),
                () -> assertEquals(NUMBER, documentDto.number()),
                () -> assertEquals(COUNTRY, documentDto.issuingCountry()),
                () -> assertFalse(documentDto.isActive())
        );
    }

    @Test
    void toEntity() {

        final DocumentDto documentDto =
                new DocumentDto(DOCUMENT_TYPE,
                                NUMBER,
                                COUNTRY,
                                true);

        final Document document = DocumentMapper.toEntity(documentDto);

        assertAll(
                () -> assertEquals(DOCUMENT_TYPE, document.getDocumentType()),
                () -> assertEquals(NUMBER, document.getDocumentNumber()),
                () -> assertEquals(COUNTRY, document.getCountry()),
                () -> assertTrue(document.isActive())
        );

    }
}