package sk.posam.fsa.jpa;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.Animal;
import sk.posam.fsa.AnimalRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaAnimalRepositoryAdapter implements AnimalRepository {

    private final AnimalSpringDataRepository animalSpringDataRepository;

    public JpaAnimalRepositoryAdapter(AnimalSpringDataRepository animalSpringDataRepository) {
        this.animalSpringDataRepository = animalSpringDataRepository;
    }

    @Override
    public Animal get(Long id) {
        Optional<Animal> optionalAnimal = animalSpringDataRepository.findById(id);
        return optionalAnimal.orElse(null);
    }

    @Override
    public Animal get(String name) {
        Optional<Animal> optionalAnimal = animalSpringDataRepository.findAnimalByName(name);
        return optionalAnimal.orElse(null);
    }

    @Override
    public void delete(Animal animal) {
        animalSpringDataRepository.delete(animal);
    }

    @Override
    public void create(Animal animal) {
        animalSpringDataRepository.save(animal);
    }

    @Override
    public List<Animal> getAll() {
        return animalSpringDataRepository.findAll();
    }

    @Override
    public List<Animal> getAllAnimalsWithinTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        return null;
    }
}