package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;

//    INDEX
//    Get all flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

}
