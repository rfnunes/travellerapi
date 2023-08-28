package com.travellerapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public final class TravellerDto {

    private final Long id;

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @Past
    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull
    private final Date birthDate;

    @NotBlank
    @Email
    private final String emailAddress;

    @NotBlank
    @Pattern(regexp = "\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}")
    private final String mobileNumber;

    //@NotEmpty
    private final Set<DocumentDto> documentDtoSet;

    public TravellerDto(Long id,
                        String firstName,
                        String lastName,
                        Date birthDate,
                        String emailAddress,
                        String mobileNumber,
                        Set<DocumentDto> documentDtoSet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.documentDtoSet = documentDtoSet;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Set<DocumentDto> getDocumentDtoSet() {
        return documentDtoSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravellerDto that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(firstName,
                                                             that.firstName) && Objects.equals(
                lastName,
                that.lastName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(
                emailAddress,
                that.emailAddress) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(
                documentDtoSet,
                that.documentDtoSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, emailAddress, mobileNumber, documentDtoSet);
    }

    @Override
    public String toString() {
        return "TravellerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", documentDtoSet=" + documentDtoSet +
                '}';
    }
}
