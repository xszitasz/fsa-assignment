package sk.posam.fsa;

import java.time.LocalDateTime;
import java.util.List;

public interface AnimalRepository {
    Animal get(Long id);
    Animal get(String name);
    void delete(Animal animal);
    void create(Animal animal);
    List<Animal> getAll();
    List<Animal> getAllAnimalsWithinTimeRange(LocalDateTime startTime, LocalDateTime endTime);
}
