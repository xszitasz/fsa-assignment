package com.posam.fsaassignment.beans;

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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public AnimalType getType() {
        return type;
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

    public void setType(AnimalType type) {
        this.type = type;
    }
}
