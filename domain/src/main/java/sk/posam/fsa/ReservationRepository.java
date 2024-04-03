package sk.posam.fsa;

import java.util.List;

public interface ReservationRepository {
    List<Reservation> get(long id);
    List<Reservation> get(String name);
    void create(Reservation reservation);
}