package com.example.airline_api.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber; // Used String because number is too big for int and long (throws an error)

    private List<Flight> flights;

    public Passenger(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flights = new ArrayList<>();
    }

    public Passenger(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void addFlights(Flight flight) {
        this.flights.add(flight);
    }

    public void removeFlight(Flight flight){
        this.flights.remove(flight);
    }
}
