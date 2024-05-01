package sk.posam.fsa.service;

import sk.posam.fsa.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CreditService implements CreditFacade{
    private final CreditRepository creditRepository;
    private final ReservationFacade reservationFacade;

    public CreditService(CreditRepository creditRepository, ReservationFacade reservationFacade) {
        this.creditRepository = creditRepository;
        this.reservationFacade = reservationFacade;
    }

    @Override
    public Optional<Credit> get(Long id) {
        return this.creditRepository.get(id);
    }

    @Override
    public void update(Credit credit) {
        this.creditRepository.update(credit);
    }

    @Override
    public int calculateCoefficient(int reservationCount) {
        return (reservationCount >= 50 && reservationCount < 100) ? 2 : (reservationCount >= 100) ? 3 : 1;
    }

    @Override
    public List<Reservation> getUserApprovedPastReservations(Long userId, LocalDateTime today) {
        return reservationFacade.getAll().stream()
                .filter(reservation -> reservation.getUser().getId().equals(userId))
                .filter(reservation -> reservation.getStatus() == ReservationStatus.APPROVED)
                .filter(reservation -> reservation.getEndTime().isBefore(today))
                .toList();
    }
}
