package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

//    INDEX
//    Get all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

//    SHOW
//    Get passenger by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }

//    CREATE
//    Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody PassengerDTO passengerDTO){
        Passenger passenger = passengerService.savePassenger(passengerDTO);
        return  new ResponseEntity<>(passenger, HttpStatus.CREATED);

    }

//   UPDATE
//   Book passenger on to flight
    @PutMapping(value = "/{id}")
    public ResponseEntity<Passenger> bookFlight(@RequestBody PassengerDTO passengerDTO, @PathVariable Long id){
        Passenger updatedPassenger = passengerService.updatePassenger(passengerDTO, id);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }


}
