package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findFlight(Long flightId) {
        return flightRepository.findById(flightId).get();
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void removeFlightIdsFromAllPassengers(Long id) {
        Flight flight = flightRepository.findById(id).get();
//        for loop to delete flight in the passenger objects
        for (Passenger passenger : flight.getPassengers()) {
            passenger.removeFlight(flight);
            passengerRepository.save(passenger);
        } flightRepository.deleteById(id);
    }

//    incomplete code to remove one flight for one passenger and not affect booking for other passengers

//    public void removeFlightIdsFromPassenger(Long id) {
//        Flight flight = flightRepository.findById(id).get();
//        passenger.removeFlight(flight);
//        passengerRepository.save(passenger);
//    }
}
