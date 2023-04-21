package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            passenger.addFlights(flight);
        }
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(PassengerDTO passengerDTO, Long id) {
        Passenger passengerToUpdate = passengerRepository.findById(id).get();
        passengerToUpdate.setName(passengerDTO.getName());
        passengerToUpdate.setPhoneNumber(passengerDTO.getPhoneNumber());
        passengerToUpdate.setFlights(new ArrayList<>());
        for(Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightService.findFlight(flightId);
            passengerToUpdate.addFlights(flight);
        }
        return passengerRepository.save(passengerToUpdate);
    }

//   THREW ERROR WHEN @AUTOWIRED PASSENGER SERVICE INTO FLIGHT SERVICE
//    WANTED TO USE SPECIFIED SERVICES TO ACCESS SPECIFIED REPOSITORIES
//    FLIGHT SERVICE ONLY HAS ACCESS TO FLIGHT REPOSITORY
//    THEREFORE THE SAVEUPDATEDPASSENGER IS NOW OBSELETE

//    public Passenger saveUpdatedPassenger(Passenger passenger){
//        return passengerRepository.save(passenger);
//    }



//    Attempt at cancel one booking for one passenger
    public Passenger findFlightAndCancelBooking(Long passengerId, Long flightId){
        Passenger passenger =  passengerRepository.findById(passengerId).get();
        Flight foundFlight =flightService.findFlight(flightId);
        passenger.removeFlight(foundFlight);
        return passengerRepository.save(passenger);
    }
}
