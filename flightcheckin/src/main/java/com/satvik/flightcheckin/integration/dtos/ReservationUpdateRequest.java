package com.satvik.flightcheckin.integration.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationUpdateRequest {
    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;
}
