package com.satvik.flightcheckin.integration.dtos;


import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter

public class Flight {
    private Long id;
    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;


}
