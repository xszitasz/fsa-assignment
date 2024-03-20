package com.posam.fsaassignment.entities;

import com.posam.fsaassignment.enums.ReservationStatus;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime created;
    @Nonnull
    private LocalDateTime startTime;
    @Nonnull
    private LocalDateTime endTime;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @NonNull
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @NonNull
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setStartTime(@NonNull LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(@NonNull LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void cancel() {

    }

    public void reject() {

    }

    public void approve() {

    }
}
