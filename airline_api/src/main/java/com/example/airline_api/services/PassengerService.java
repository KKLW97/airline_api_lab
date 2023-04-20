package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightService flightService;

    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger findPassenger(Long passengerId) {
        return passengerRepository.findById(passengerId).get();
    }

    public Passenger savePassenger(PassengerDTO passengerDTO) {
//        Create passenger object from the DTO
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getPhoneNumber());
//        Find all flights based on the flightIds of the DTO
//        Add all flights to the passenger
        for(Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightService.findFlight(flightId);
            passenger.addFlight(flight);
        }
        return passengerRepository.save(passenger);
    }
}
