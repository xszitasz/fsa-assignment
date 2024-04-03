package sk.posam.fsa.service;

import org.springframework.stereotype.Service;

import sk.posam.fsa.User;
import sk.posam.fsa.UserRepository;

@Service
public class UserService implements UserFacade {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(long id) {
        return userRepository.get(id);
    }

    @Override
    public User get(String name) {
        return userRepository.get(name);
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }
}
