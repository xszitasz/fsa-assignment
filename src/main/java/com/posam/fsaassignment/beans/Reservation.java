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

    public void setId(long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void cancel() {

    }

    public void reject() {

    }

    public void approve() {

    }
}
