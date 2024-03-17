package com.posam.fsaassignment.beans;

import java.time.LocalDateTime;

public class Reservation {
    private long id;
    private LocalDateTime created;
    private LocalDateTime start;
    private LocalDateTime end;

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void cancel() {

    }

    public void reject() {

    }

    public void approve() {

    }
}
