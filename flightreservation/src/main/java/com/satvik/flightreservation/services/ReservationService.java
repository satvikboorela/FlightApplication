package com.satvik.flightreservation.services;

import com.satvik.flightreservation.dtos.ReservationRequest;
import com.satvik.flightreservation.entities.Reservation;

public interface ReservationService {

    Reservation bookFlight(ReservationRequest request);
}
