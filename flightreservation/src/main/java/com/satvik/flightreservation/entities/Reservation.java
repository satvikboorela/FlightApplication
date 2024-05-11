package com.satvik.flightreservation.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToOne;
import lombok.*;


@Getter
@Setter
@Entity
public class Reservation extends AbstractEntity{
    private Boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;

}
