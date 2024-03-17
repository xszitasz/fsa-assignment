package com.posam.fsaassignment.repositories;

import com.posam.fsaassignment.beans.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByType(Animal type);
}
