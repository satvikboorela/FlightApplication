package com.satvik.flightcheckin.integration;

import com.satvik.flightcheckin.integration.dtos.Reservation;
import com.satvik.flightcheckin.integration.dtos.ReservationUpdateRequest;

public interface ReservationRestClient {
    public Reservation findReservation(Long id);
    public Reservation updateReservation(ReservationUpdateRequest request);
}
