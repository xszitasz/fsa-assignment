package com.posam.fsaassignment.services;

import com.posam.fsaassignment.entities.Animal;
import com.posam.fsaassignment.enums.AnimalType;
import com.posam.fsaassignment.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private static AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        AnimalService.animalRepository = animalRepository;
    }

    public static List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public List<Animal> getAllDogs() {
        return animalRepository.findAll().stream()
                .filter(animal -> animal.getRace().getType() == AnimalType.DOG)
                .collect(Collectors.toList());
    }

    public List<Animal> getAllCats() {
        return animalRepository.findAll().stream()
                .filter(animal -> animal.getRace().getType() == AnimalType.CAT)
                .collect(Collectors.toList());
    }

    public Optional<Animal> getAnimalById(long id) {
        return animalRepository.findById(id);
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        if (animalRepository.existsById(animal.getId())) {
            return animalRepository.save(animal);
        } else {
            throw new IllegalArgumentException("Animal with ID " + animal.getId() + " not found");
        }
    }

    public void deleteAnimalById(long id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Animal with ID " + id + " not found");
        }
    }
}