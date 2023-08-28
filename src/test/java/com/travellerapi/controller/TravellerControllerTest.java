package com.travellerapi.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.travellerapi.dto.DocumentDto;
import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.DocumentType;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.SerializationFeature;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TravellerControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    static {
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.setDateFormat(DATE_FORMAT);
    }

    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @MethodSource
    void createTravellerValidationTest_hasError(final TravellerDto travellerDto) throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/traveller")
                                          .content(asJsonString(travellerDto))
                                          .contentType(MediaType.APPLICATION_JSON)
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isBadRequest());
    }

    static Stream<Arguments> createTravellerValidationTest_hasError() throws ParseException {
        return Stream.of(
                Arguments.of(createTravellerDto(null,
                                                "lastName",
                                                DATE_FORMAT.parse("01-01-1970"),
                                                "admin@mail.com",
                                                "+351210000000",
                                                Set.of(new DocumentDto(DocumentType.ID_CARD,
                                                                       "12345",
                                                                       "PT",
                                                                       true)))),
                Arguments.of(createTravellerDto("firstName",
                                                null,
                                                DATE_FORMAT.parse("01-01-1970"),
                                                "admin@mail.com",
                                                "+351210000000",
                                                Set.of(new DocumentDto(DocumentType.ID_CARD,
                                                                       "12345",
                                                                       "PT",
                                                                       true)))),
                Arguments.of(createTravellerDto("firstName",
                                                "lastName",
                                                null,
                                                "admin@mail.com",
                                                "+351210000000",
                                                Set.of(new DocumentDto(DocumentType.ID_CARD,
                                                                       "12345",
                                                                       "PT",
                                                                       true)))),
                Arguments.of(createTravellerDto("firstName",
                                                null,
                                                DATE_FORMAT.parse("01-01-2970"),
                                                "admin@mail.com",
                                                "+351210000000",
                                                Set.of(new DocumentDto(DocumentType.ID_CARD,
                                                                       "12345",
                                                                       "PT",
                                                                       true)))),
                Arguments.of(createTravellerDto("firstName",
                                                "lastName",
                                                DATE_FORMAT.parse("01-01-1970"),
                                                null,
                                                "+351210000000",
                                                Set.of(new DocumentDto(DocumentType.ID_CARD,
                                                                       "12345",
                                                                       "PT",
                                                                       true)))),
                Arguments.of(createTravellerDto("firstName",
                                                null,
                                                DATE_FORMAT.parse("01-01-1970"),
                                                "admin@mail.com",
                                                null,
                                                Set.of(new DocumentDto(DocumentType.ID_CARD,
                                                                       "12345",
                                                                       "PT",
                                                                       true)))),
                Arguments.of(createTravellerDto("firstName",
                                                null,
                                                DATE_FORMAT.parse("01-01-1970"),
                                                "admin@mail.com",
                                                null,
                                                Collections.emptySet())));
    }

    @Test
    void createTravellerValidationTest() throws Exception {

        final TravellerDto travellerDto =
                createTravellerDto("firstName",
                                   "lastName",
                                   DATE_FORMAT.parse("01-01-1970"),
                                   "admin@mail.com",
                                   "+351210000000",
                                   Set.of(new DocumentDto(DocumentType.ID_CARD,
                                                          "12345",
                                                          "PT",
                                                          true)));

        mvc.perform(MockMvcRequestBuilders.post("/traveller")
                                          .content(asJsonString(travellerDto))
                                          .contentType(MediaType.APPLICATION_JSON)
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk());
    }

    @NotNull
    private static TravellerDto createTravellerDto(final String firstName,
                                                   final String lastName,
                                                   final Date birthDate,
                                                   final String email,
                                                   final String mobileNumber,
                                                   Set<DocumentDto> documents) {
        return new TravellerDto(0L,
                                firstName,
                                lastName,
                                birthDate,
                                email,
                                mobileNumber,
                                documents);
    }

    private static String asJsonString(final Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}