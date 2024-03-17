package com.posam.fsaassignment.beans;

import com.posam.fsaassignment.enums.Race;
import com.posam.fsaassignment.enums.AnimalType;
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
    private AnimalType type;
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
}
