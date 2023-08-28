package com.travellerapi.controller;

import com.travellerapi.dto.TravellerDto;
import com.travellerapi.model.DocumentType;
import com.travellerapi.service.ITravellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravellerController {

    @Autowired
    private ITravellerService travellerService;

    @PostMapping("/traveller")
    @ResponseBody
    public ResponseEntity<TravellerDto> createTraveller(@Valid @RequestBody final TravellerDto travellerDto) {
        return ResponseEntity.ok(travellerService.createTraveller(travellerDto));
    }

    @GetMapping("/traveller/{id}")
    @ResponseBody
    public ResponseEntity<TravellerDto> getTravellerByEmail(@PathVariable final long id) {
        return ResponseEntity.ofNullable(travellerService.getTraveller(id));
    }

    @GetMapping("/traveller/email/{email}")
    @ResponseBody
    public ResponseEntity<TravellerDto> getTravellerByEmail(@PathVariable final String email) {
        return ResponseEntity.ofNullable(travellerService.getTravellerByEmail(email));
    }

    @GetMapping("/traveller/mobile/{mobile}")
    @ResponseBody
    public ResponseEntity<TravellerDto> getTravellerByMobile(@PathVariable final String mobile) {
        return ResponseEntity.ofNullable(travellerService.getTravellerByMobile(mobile));
    }

    @GetMapping("/traveller/document?number={number}&type={type}&country={country}")
    @ResponseBody
    public ResponseEntity<TravellerDto> getTravellerByDocument(@RequestParam final DocumentType documentType,
                                                               @RequestParam final String number,
                                                               @RequestParam final String country) {
        return ResponseEntity.ok(travellerService.getTravellerByDocument(documentType, number, country));
    }

    @PutMapping("/traveller")
    @ResponseBody
    public ResponseEntity<TravellerDto> updateTraveller(@RequestBody final TravellerDto travellerDto) {
        //travellerService.updateTraveller(traveller);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PutMapping("/traveller/deactivate/{id}")
    @ResponseBody
    public ResponseEntity<Void> deactivateTraveller(@PathVariable final long id) {
        //travellerService.deactivateTraveller(id);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
