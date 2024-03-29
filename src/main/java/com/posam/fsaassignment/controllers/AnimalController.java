package com.posam.fsaassignment.controllers;

import com.posam.fsaassignment.entities.Animal;
import com.posam.fsaassignment.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/get/animals")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animals = AnimalService.getAllAnimals();
        return ResponseEntity.ok(animals);
    }

    @GetMapping("/get/dogs")
    public ResponseEntity<List<Animal>> getAllDogs() {
        List<Animal> dogs = animalService.getAllDogs();
        return ResponseEntity.ok(dogs);
    }

    @GetMapping("/get/cats")
    public ResponseEntity<List<Animal>> getAllCats() {
        List<Animal> cats = animalService.getAllCats();
        return ResponseEntity.ok(cats);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable long id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.createAnimal(animal);
        return new ResponseEntity<>(createdAnimal, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable long id, @RequestBody Animal animal) {
        animal.setId(id);
        Animal updatedAnimal = animalService.updateAnimal(animal);
        return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnimalById(@PathVariable long id) {
        animalService.deleteAnimalById(id);
        return ResponseEntity.noContent().build();
    }
}
