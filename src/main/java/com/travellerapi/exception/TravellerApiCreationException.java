package com.travellerapi.exception;

public class TravellerApiCreationException extends RuntimeException {

    private final Exception exception;

    public TravellerApiCreationException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return "Traveller could not be created: " + exception.getMessage();
    }
}
