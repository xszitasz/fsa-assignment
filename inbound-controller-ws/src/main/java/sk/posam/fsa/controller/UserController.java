package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.User;
import sk.posam.fsa.mapper.UserMapper;
import sk.posam.fsa.rest.dto.UserDto;
import sk.posam.fsa.rest.dto.UserRoleDto;
import sk.posam.fsa.security.CurrentUserDetailService;
import sk.posam.fsa.service.UserFacade;

@RestController
public class UserController implements sk.posam.fsa.rest.api.UsersApi{
    private final UserMapper userMapper;
    private final CurrentUserDetailService currentUserDetailService;
    private final UserFacade userFacade;

    public UserController(UserMapper userMapper, CurrentUserDetailService currentUserDetailService, UserFacade userFacade) {
        this.userMapper = userMapper;
        this.currentUserDetailService = currentUserDetailService;
        this.userFacade = userFacade;
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        UserRoleDto userRole = currentUserDetailService.getCurrentUser().getRole();

        if (userRole != UserRoleDto.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        User user = userMapper.toUserEntity(userDto);
        user.setId(null);
        userFacade.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
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
