package sk.posam.fsa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.Reservation;

import java.util.Optional;

@Repository
public interface ReservationSpringDataRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findReservationById(Long id);
}