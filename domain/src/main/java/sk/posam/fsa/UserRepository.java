package sk.posam.fsa;

public interface UserRepository {
    User get(long id);
    User get(String name);
    void create(User user);
}
