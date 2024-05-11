package com.satvik.flightreservation.services;

import com.satvik.flightreservation.dtos.ReservationRequest;
import com.satvik.flightreservation.entities.Flight;
import com.satvik.flightreservation.entities.Passenger;
import com.satvik.flightreservation.entities.Reservation;
import com.satvik.flightreservation.repos.FlightRepository;
import com.satvik.flightreservation.repos.PassengerRepository;
import com.satvik.flightreservation.repos.ReservationRepository;
import com.satvik.flightreservation.util.EmailUtil;
import com.satvik.flightreservation.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;


    @Override
    public Reservation bookFlight(ReservationRequest request) {
        Flight flight= flightRepository.findById(request.getFlightId()).get();
        Passenger passenger= new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());

        Passenger savedPassenger= passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation= reservationRepository.save(reservation);
        String filePath= "/Users/satvikboorela/Desktop/Reservations/reservation" + savedReservation.getId() + ".pdf";
        pdfGenerator.generateItinary(savedReservation, filePath);
        emailUtil.sendItinerary(passenger.getEmail(), filePath);
        return savedReservation;
    }
}
