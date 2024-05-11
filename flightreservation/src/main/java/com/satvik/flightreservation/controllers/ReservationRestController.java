package com.satvik.flightreservation.controllers;

import com.satvik.flightreservation.dtos.ReservationUpdateRequest;
import com.satvik.flightreservation.entities.Reservation;
import com.satvik.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {

        return reservationRepository.findById(id).get();

    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        //LOGGER.info("Inside updateReservation() for " + request);
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
       // LOGGER.info("Saving Reservation");
        return reservationRepository.save(reservation);

    }
}
