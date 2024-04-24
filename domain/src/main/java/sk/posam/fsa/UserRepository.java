package sk.posam.fsa;

public interface UserRepository {
    User get(Long id);
    User get(String email);
    void create(User user);
}
