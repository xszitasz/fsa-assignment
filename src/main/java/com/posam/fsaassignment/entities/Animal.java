package com.posam.fsaassignment.entities;

import com.posam.fsaassignment.enums.Race;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDateTime created;
    @Enumerated(EnumType.STRING)
    private Race race;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Race getRace() {
        return race;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
