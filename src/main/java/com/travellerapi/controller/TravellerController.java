package com.travellerapi.controller;

import com.travellerapi.dto.DocumentType;
import com.travellerapi.dto.Traveller;
import com.travellerapi.service.TravellerService;
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
    private TravellerService travellerService;

    @PostMapping("/traveller")
    @ResponseBody
    public ResponseEntity<Traveller> createTraveller(@RequestBody final Traveller traveller) {
        return ResponseEntity.ok(travellerService.createTraveller(traveller));
    }

    @GetMapping("/traveller/{id}")
    @ResponseBody
    public ResponseEntity<Traveller> getTravellerByEmail(@PathVariable final long id) {
        return ResponseEntity.ofNullable(travellerService.getTraveller(id));
    }

    @GetMapping("/traveller/email/{email}")
    @ResponseBody
    public ResponseEntity<Traveller> getTravellerByEmail(@PathVariable final String email) {
        return ResponseEntity.ofNullable(travellerService.getTravellerByEmail(email));
    }

    @GetMapping("/traveller/mobile/{mobile}")
    @ResponseBody
    public ResponseEntity<Traveller> getTravellerByMobile(@PathVariable final String mobile) {
        return ResponseEntity.ofNullable(travellerService.getTravellerByMobile(mobile));
    }

    @GetMapping("/traveller/document?number={number}&type={type}&country={country}")
    @ResponseBody
    public ResponseEntity<Traveller> getTravellerByDocument(@RequestParam final DocumentType documentType,
                                                            @RequestParam final String number,
                                                            @RequestParam final String country) {
        return ResponseEntity.ok(travellerService.getTravellerByDocument(documentType, number, country));
    }

    @PutMapping("/traveller")
    @ResponseBody
    public ResponseEntity<Traveller> updateTraveller(@RequestBody final Traveller traveller) {
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
