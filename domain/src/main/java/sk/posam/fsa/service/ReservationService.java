package sk.posam.fsa.service;

import sk.posam.fsa.Reservation;
import sk.posam.fsa.ReservationRepository;

import java.util.List;

public class ReservationService implements ReservationFacade{
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation get(Long id) {
        return reservationRepository.get(id);
    }

    @Override
    public void create(Reservation reservation) {
        reservationRepository.create(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }
}
