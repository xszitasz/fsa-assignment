package sk.posam.fsa;

import java.util.List;

public interface AnimalRepository {
    Animal get(long id);
    Animal get(String name);
    void create(Animal animal);
    List<Animal> getAll();
}
