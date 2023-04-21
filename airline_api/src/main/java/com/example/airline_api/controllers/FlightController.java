package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    SHOW
//    Get flight by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }

//    CREATE
//    Add a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

//    DESTROY
//    Cancel Flight Booking
//    cancels flight bookings for all passengers
//    can alter code to delete for just one passenger rather than all passengers by removing the for loop
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.removeFlightIdsFromAllPassengers(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Long> cancelFlightBookingForPassenger(@PathVariable Long id){
//        flightService.removeFlightIdsFromPassenger(id);
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }
}
