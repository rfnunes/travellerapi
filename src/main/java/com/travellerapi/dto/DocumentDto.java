package com.travellerapi.dto;

import com.travellerapi.model.DocumentType;

public record DocumentDto(DocumentType documentType,
                          String number,
                          String issuingCountry,
                          boolean isActive) {
}
