package com.posam.fsaassignment.controllers;

import com.posam.fsaassignment.entities.Animal;
import com.posam.fsaassignment.entities.Reservation;
import com.posam.fsaassignment.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/available-animals")
    public List<Animal> findAvailableAnimals(
            @RequestParam("start_time") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam("end_time") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        return reservationService.findAvailableAnimals(startTime, endTime);
    }

    @GetMapping("/get/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/get/{id}")
    public Reservation getReservationById(@PathVariable long id) {
        return reservationService.getReservationById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation with ID " + id + " not found"));
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/put/{id}")
    public Reservation updateReservation(@PathVariable long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservationById(@PathVariable long id) {
        reservationService.deleteReservationById(id);
    }
}
