package sk.posam.fsa.jpa;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.Reservation;
import sk.posam.fsa.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaReservationRepositoryAdapter implements ReservationRepository {
    private final ReservationSpringDataRepository reservationSpringDataRepository;

    public JpaReservationRepositoryAdapter(ReservationSpringDataRepository reservationSpringDataRepository) {
        this.reservationSpringDataRepository = reservationSpringDataRepository;
    }

    @Override
    public Reservation get(Long id) {
        Optional<Reservation> optionalReservation = reservationSpringDataRepository.findReservationById(id);
        return optionalReservation.orElse(null);
    }

    @Override
    public void create(Reservation reservation) {
        reservationSpringDataRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationSpringDataRepository.findAll();
    }
}
