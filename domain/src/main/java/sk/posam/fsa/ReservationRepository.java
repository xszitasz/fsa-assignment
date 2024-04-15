package sk.posam.fsa;

import java.util.List;

public interface ReservationRepository {
    Reservation get(long id);
    void create(Reservation reservation);

    List<Reservation> getAll();
}