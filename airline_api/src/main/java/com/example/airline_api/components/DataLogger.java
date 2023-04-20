package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLogger implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLogger(){

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        HAWAII FLIGHT
        Flight hawaiiFlight = new Flight("Hawaii", "Monday", "Morning");
        flightRepository.save(hawaiiFlight);

        Passenger aubreySmith = new Passenger("Aubrey Smith", "07345684990");
        passengerRepository.save(aubreySmith);

        Passenger marlinDaniels = new Passenger("Marlin Daniels", "07563789425");
        passengerRepository.save(marlinDaniels);

//        SOUTH KOREA FLIGHT
        Flight southKoreaFlight = new Flight("South Korea", "Friday", "Afternoon");
        flightRepository.save(southKoreaFlight);

        Passenger ryanStuart = new Passenger("Ryan Stuart", "07876345122");
        passengerRepository.save(ryanStuart);

        Passenger lolaGrace = new Passenger("Lola Grace", "07343221892");
        passengerRepository.save(lolaGrace);

//        AUSTRALIA FLIGHT
        Flight australiaFlight = new Flight("Australia", "Wednesday", "Midday");
        flightRepository.save(australiaFlight);

        Passenger dahliaWells = new Passenger("Dahlia Wells", "07892234561");
        passengerRepository.save(dahliaWells);

        Passenger devonDoom = new Passenger("Devon Doom", "07889932144");
        passengerRepository.save(devonDoom);

//        Assign multiple flights to passengers:
        aubreySmith.addFlights(hawaiiFlight);
        aubreySmith.addFlights(australiaFlight);
        marlinDaniels.addFlights(hawaiiFlight);
        ryanStuart.addFlights(southKoreaFlight);
        ryanStuart.addFlights(hawaiiFlight);
        lolaGrace.addFlights(southKoreaFlight);
        lolaGrace.addFlights(australiaFlight);
        devonDoom.addFlights(australiaFlight);
        devonDoom.addFlights(hawaiiFlight);
        dahliaWells.addFlights(australiaFlight);
        dahliaWells.addFlights(southKoreaFlight);
        dahliaWells.addFlights(hawaiiFlight);

        passengerRepository.save(aubreySmith);
        passengerRepository.save(marlinDaniels);
        passengerRepository.save(ryanStuart);
        passengerRepository.save(lolaGrace);
        passengerRepository.save(devonDoom);
        passengerRepository.save(dahliaWells);
    }
}
