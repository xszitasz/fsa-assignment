package sk.posam.fsa.service;

import sk.posam.fsa.User;
import sk.posam.fsa.UserRepository;

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
    public User get(String email) {
        return userRepository.get(email);
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }
}
