package sk.posam.fsa.service;

import org.springframework.stereotype.Service;

import sk.posam.fsa.AnimalRepository;
import sk.posam.fsa.Animal;

@Service
public class AnimalService implements AnimalFacade {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal get(long id) {
        return animalRepository.get(id);
    }

    @Override
    public Animal get(String name) {
        return animalRepository.get(name);
    }

    @Override
    public void create(Animal animal) {
        animalRepository.create(animal);
    }
}