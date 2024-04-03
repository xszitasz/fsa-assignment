package sk.posam.fsa;

public interface AnimalRepository {
    Animal get(long id);
    Animal get(String name);
    void create(Animal animal);
}
