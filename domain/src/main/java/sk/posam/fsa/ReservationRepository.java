package sk.posam.fsa;

import java.util.List;

public interface ReservationRepository {
    Reservation get(Long id);
    void create(Reservation reservation);
    List<Reservation> getAll();
    void update(Reservation reservation);
}