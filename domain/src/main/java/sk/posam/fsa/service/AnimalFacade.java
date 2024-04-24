package sk.posam.fsa.service;

import sk.posam.fsa.Animal;

import java.time.LocalDateTime;
import java.util.List;

public interface AnimalFacade {
    Animal get(Long id);
    Animal get(String name);
    void create(Animal animal);
    List<Animal> getAll();
    List<Animal> getAllAnimalsWithinTimeRange(LocalDateTime startTime, LocalDateTime endTime);
}
