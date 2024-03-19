package com.posam.fsaassignment.repositories;

import com.posam.fsaassignment.entities.Animal;
import com.posam.fsaassignment.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT a FROM Animal a WHERE a NOT IN (SELECT r.animal FROM Reservation r " +
            "WHERE r.endTime > :startTime AND r.startTime < :endTime)")
    List<Animal> findAvailableAnimals(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}