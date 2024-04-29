package sk.posam.fsa.service;

import sk.posam.fsa.Reservation;

import java.util.List;

public interface ReservationFacade {
    Reservation get(Long id);
    void create(Reservation reservation);
    List<Reservation> getAll();
    void update(Reservation reservation);
}
