package com.posam.fsaassignment.services;

import com.posam.fsaassignment.entities.Animal;
import com.posam.fsaassignment.entities.Reservation;
import com.posam.fsaassignment.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

//    @Transactional
//    public Reservation createReservation(LocalDateTime startTime, LocalDateTime endTime, User user, Animal animal) {
//        if (startTime == null || endTime == null || user == null || animal == null) {
//            throw new IllegalArgumentException("Invalid input parameters for reservation creation");
//        }
//
//        Reservation reservation = new Reservation();
//        reservation.setStartTime(startTime);
//        reservation.setEndTime(endTime);
//        reservation.setUser(user);
//        reservation.setAnimal(animal);
//        reservation.setStatus(ReservationStatus.PENDING);
//        reservation.setCreated(LocalDateTime.now());
//
//        return reservationRepository.save(reservation);
//    }

    public List<Animal> findAvailableAnimals(LocalDateTime startTime, LocalDateTime endTime) {
        return reservationRepository.findAvailableAnimals(startTime, endTime);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        reservation.setCreated(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        if (reservationRepository.existsById(reservation.getId())) {
            return reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("Reservation with ID " + reservation.getId() + " not found");
        }
    }

    public void deleteReservationById(long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Reservation with ID " + id + " not found");
        }
    }
}
