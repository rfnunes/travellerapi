package com.travellerapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DocumentId implements Serializable {

    @Column(name="type", nullable = false)
    private DocumentType documentType;

    private String number;

    private String country;

    public static DocumentId of(final DocumentType documentType,
                                final String number,
                                final String country) {
        DocumentId documentId = new DocumentId();
        documentId.setDocumentType(documentType);
        documentId.setNumber(number);
        documentId.setCountry(country);
        return documentId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentId that)) return false;
        return getDocumentType() == that.getDocumentType() && Objects.equals(getNumber(),
                                                                             that.getNumber()) && Objects.equals(
                getCountry(),
                that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocumentType(), getNumber(), getCountry());
    }

    @Override
    public String toString() {
        return "DocumentId{" +
                "documentType=" + documentType +
                ", number='" + number + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
