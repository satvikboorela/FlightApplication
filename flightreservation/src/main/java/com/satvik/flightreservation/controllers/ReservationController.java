package com.satvik.flightreservation.controllers;

import com.satvik.flightreservation.dtos.ReservationRequest;
import com.satvik.flightreservation.entities.Flight;
import com.satvik.flightreservation.entities.Reservation;
import com.satvik.flightreservation.repos.FlightRepository;
import com.satvik.flightreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long FlightId, ModelMap modelMap) {
        Flight flight = flightRepository.findById(FlightId).get();
        modelMap.addAttribute("flight", flight);
        return "completeReservation";

    }
    @PostMapping("/completeReservation")
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
        Reservation reservation= reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation Created Successfully reservation id is: " + reservation.getId());
        return "reservationConfirmation";
    }
}
