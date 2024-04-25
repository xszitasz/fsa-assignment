package sk.posam.fsa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.mapper.UserMapper;
import sk.posam.fsa.rest.dto.UserDto;
import sk.posam.fsa.security.CurrentUserDetailService;

@RestController
public class UserController implements sk.posam.fsa.rest.api.UsersApi{
    private final UserMapper userMapper;
    private final CurrentUserDetailService currentUserDetailService;

    public UserController(UserMapper userMapper, CurrentUserDetailService currentUserDetailService) {
        this.userMapper = userMapper;
        this.currentUserDetailService = currentUserDetailService;
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> getUserByEmail(String email) {
        return ResponseEntity.ok(userMapper.toUserDto(currentUserDetailService.getFullCurrentUser()));
    }

    @Override
    public ResponseEntity<UserDto> getUserById(Long id) {
        return null;
    }
}
