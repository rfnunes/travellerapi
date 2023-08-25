package com.travellerapi.dto;

public record Document(DocumentType documentType,
                       String number,
                       String issuingCountry,
                       boolean isActive) {
}
