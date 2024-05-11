package com.satvik.flightcheckin.integration;

import com.satvik.flightcheckin.integration.dtos.Reservation;
import com.satvik.flightcheckin.integration.dtos.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {



    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate
                .getForObject("http://localhost:8080/flightreservation/reservations/" + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject("http://localhost:8080/flightreservation/reservations", request, Reservation.class);
        return reservation;
    }
}
