package sk.posam.fsa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.Animal;

import java.util.Optional;

@Repository
public interface AnimalSpringDataRepository extends JpaRepository<Animal, Long> {

    Optional<Animal> findAnimalByName (String name);
}
