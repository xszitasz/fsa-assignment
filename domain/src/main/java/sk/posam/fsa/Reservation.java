package sk.posam.fsa;

import java.time.LocalDateTime;

public class Reservation {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ReservationStatus status;
    private User user;
    private Animal animal;

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
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
