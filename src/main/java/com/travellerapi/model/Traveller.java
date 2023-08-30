package com.travellerapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Traveller", uniqueConstraints = {
        @UniqueConstraint(name = "uc_traveller_emailaddress", columnNames = {"emailAddress", "mobileNumber"/*, "activeDocument"*/})
})
public class Traveller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, unique = true)
    private String emailAddress;

    @Column(nullable = false, unique = true)
    private String mobileNumber;

    //@OneToOne
    //private Document activeDocument;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Document> documentSet;

    @Column(nullable = false)
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<Document> getDocumentSet() {
        return documentSet;
    }

    public void setDocumentSet(Set<Document> documentSet) {
        this.documentSet = documentSet;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", documentSet=" + documentSet +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Traveller traveller)) return false;
        return isActive() == traveller.isActive() && Objects.equals(getId(),
                                                                    traveller.getId()) && Objects.equals(
                getFirstName(),
                traveller.getFirstName()) && Objects.equals(getLastName(),
                                                            traveller.getLastName()) && Objects.equals(
                getBirthDate(),
                traveller.getBirthDate()) && Objects.equals(getEmailAddress(),
                                                            traveller.getEmailAddress()) && Objects.equals(
                getMobileNumber(),
                traveller.getMobileNumber()) && Objects.equals(getDocumentSet(), traveller.getDocumentSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                            getFirstName(),
                            getLastName(),
                            getBirthDate(),
                            getEmailAddress(),
                            getMobileNumber(),
                            getDocumentSet(),
                            isActive());
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
