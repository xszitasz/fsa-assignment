package sk.posam.fsa.service;

import sk.posam.fsa.User;

public interface UserFacade {
    User get(long id);
    User get(String name);
    void create(User user);
}
