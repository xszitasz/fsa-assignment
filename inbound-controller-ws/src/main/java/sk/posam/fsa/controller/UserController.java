package sk.posam.fsa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.rest.dto.UserDto;

@RestController
public class UserController implements sk.posam.fsa.rest.api.UsersApi{
    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> getUserById(Long id) {
        return null;
    }
}
