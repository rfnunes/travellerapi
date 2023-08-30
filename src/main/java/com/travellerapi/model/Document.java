package com.travellerapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

@Entity
@Table(name = "Document")
public class Document {

    @EmbeddedId
    private DocumentId documentId;

    @Column()
    private boolean active;

    public DocumentId getDocumentId() {
        return documentId;
    }

    public void setDocumentId(DocumentId documentId) {
        this.documentId = documentId;
    }

    public DocumentType getDocumentType() {
        return getDocumentId().getDocumentType();
    }

    public String getDocumentNumber() {
        return getDocumentId().getNumber();
    }

    public String getCountry() {
        return getDocumentId().getCountry();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document document)) return false;
        return isActive() == document.isActive() && Objects.equals(getDocumentId(), document.getDocumentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocumentId(), isActive());
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", active=" + active +
                '}';
    }
}
