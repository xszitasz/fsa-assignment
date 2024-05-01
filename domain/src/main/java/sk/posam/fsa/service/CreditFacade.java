package sk.posam.fsa.service;

import sk.posam.fsa.Credit;
import sk.posam.fsa.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CreditFacade {
    Optional<Credit> get(Long id);
    void update(Credit credit);
    int calculateCoefficient(int reservationCount);
    List<Reservation> getUserApprovedPastReservations(Long userId, LocalDateTime today);
}
