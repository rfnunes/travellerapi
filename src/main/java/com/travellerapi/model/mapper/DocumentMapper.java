package com.travellerapi.model.mapper;

import com.travellerapi.dto.DocumentDto;
import com.travellerapi.model.Document;
import com.travellerapi.model.DocumentId;

public final class DocumentMapper {

    //Suppress default constructor for noninstantiability
    private DocumentMapper() {
        throw new AssertionError("DocumentMapper cannot be instantiated.");
    }

    public static DocumentDto toDto(Document document) {

        return new DocumentDto(document.getDocumentType(),
                               document.getDocumentNumber(),
                               document.getCountry(),
                               document.isActive());
    }

    public static Document toEntity(DocumentDto documentDto) {

        final Document document = new Document();
        document.setDocumentId(DocumentId.of(documentDto.documentType(),
                                             documentDto.number(),
                                             documentDto.issuingCountry()));
        document.setActive(documentDto.isActive());
        return document;
    }
}
