package com.satvik.flightcheckin.integration.dtos;

import lombok.*;


@Getter
@Setter

public class Reservation{
    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;

    private Passenger passenger;

    private Flight flight;

}
