package sk.posam.fsa.service;

import sk.posam.fsa.Animal;

import java.util.List;

public interface AnimalFacade {
    Animal get(long id);
    Animal get(String name);
    void create(Animal animal);
    List<Animal> getAll();
}
