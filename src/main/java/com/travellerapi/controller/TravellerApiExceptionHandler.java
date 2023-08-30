package com.travellerapi.controller;

import com.travellerapi.exception.TravellerApiCreationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TravellerApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TravellerApiCreationException.class)
    public ResponseEntity<Object> handleCreation(TravellerApiCreationException travellerApiCreationException,
                                                 HttpServletRequest request,
                                                 HttpServletResponse response) {
        //IMPROVE: Tidy up messages and do not expose SQL details
        return ResponseEntity.internalServerError().body(travellerApiCreationException.getMessage());
    }
}
