package com.travellerapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

@Entity
@Table(name = "Document", uniqueConstraints = {
        @UniqueConstraint(name = "uc_document_type_number", columnNames = {"type", "number", "country"})
})
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private DocumentType documentType;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String country;

    @Column()
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return isActive() == document.isActive() && Objects.equals(getId(),
                                                                   document.getId()) && getDocumentType() == document.getDocumentType() && Objects.equals(
                getNumber(),
                document.getNumber()) && Objects.equals(getCountry(), document.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDocumentType(), getNumber(), getCountry(), isActive());
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentType=" + documentType +
                ", number='" + number + '\'' +
                ", country='" + country + '\'' +
                ", active=" + active +
                '}';
    }
}
