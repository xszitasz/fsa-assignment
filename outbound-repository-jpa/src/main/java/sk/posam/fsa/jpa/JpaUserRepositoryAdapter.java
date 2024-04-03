package sk.posam.fsa.jpa;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.User;
import sk.posam.fsa.UserRepository;

import java.util.Optional;

@Repository
public class JpaUserRepositoryAdapter implements UserRepository {
    private final UserSpringDataRepository userSpringDataRepository;

    public JpaUserRepositoryAdapter(UserSpringDataRepository userSpringDataRepository) {
        this.userSpringDataRepository = userSpringDataRepository;
    }
    @Override
    public User get(long id) {
        Optional<User> user = userSpringDataRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User get(String name) {
        Optional<User> user = userSpringDataRepository.findByUserName(name);
        return user.orElse(null);
    }

    @Override
    public void create(User user) {
        userSpringDataRepository.save(user);
    }
}
