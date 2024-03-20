package com.posam.fsaassignment.entities;

import com.posam.fsaassignment.enums.Race;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nonnull
    private String name;
    @Enumerated(EnumType.STRING)
    private Race race;

    public long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
