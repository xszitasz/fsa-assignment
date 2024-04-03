package sk.posam.fsa.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sk.posam.fsa.rest.dto.UserDto;
import sk.posam.fsa.service.UserFacade;

@Service
public class CurrentUserDetailService {

    private final UserFacade userFacade;

    public CurrentUserDetailService(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public UserDto getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDto) {
            return (UserDto) principal;
        }

        throw new IllegalStateException("Current user is not of type UserDto.");
    }
}
