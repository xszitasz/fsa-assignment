package sk.posam.fsa;

import java.time.LocalDateTime;
import java.util.List;

public interface AnimalRepository {
    Animal get(long id);
    Animal get(String name);
    void create(Animal animal);
    List<Animal> getAll();
    List<Animal> getAllAnimalsWithinTimeRange(LocalDateTime startTime, LocalDateTime endTime);
}
