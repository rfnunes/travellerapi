package com.travellerapi.dto;

import java.util.Set;

public record Traveller(Long id,
                        String firstName,
                        String lastName,
                        String birthDate,
                        String emailAddress,
                        Set<Document> documentSet) {
}
