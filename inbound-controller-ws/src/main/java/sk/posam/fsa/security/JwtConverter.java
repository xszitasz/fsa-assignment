package sk.posam.fsa.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import sk.posam.fsa.rest.dto.UserDto;
import sk.posam.fsa.rest.dto.UserRoleDto;

import java.util.*;

class JwtConverter extends AbstractAuthenticationToken {
    private final Jwt source;

    public JwtConverter(Jwt source) {
        super(Collections.emptyList());
        this.source = Objects.requireNonNull(source);
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return Collections.emptyList();
    }

    @Override
    public Object getPrincipal() {
        UserDto userDto = new UserDto();
        userDto.setEmail(source.getClaimAsString("email"));
        userDto.setName(source.getClaimAsString("given_name"));
        userDto.setRole(getRole());
        return userDto;
    }

    private UserRoleDto getRole() {
        Map<String, Object> realmAccess = source.getClaimAsMap("realm_access");
        if (realmAccess == null || realmAccess.get("roles") == null) return null;

        List<String> roles = (List<String>) realmAccess.get("roles");
        Optional<UserRoleDto> userRoleDto = findRole(roles);

        return userRoleDto.orElse(null);
    }

    private Optional<UserRoleDto> findRole(List<String> roles) {
        return roles.stream()
            .filter(role -> Arrays.stream(UserRoleDto.values())
                .anyMatch(enumRole -> enumRole.name().equals(role)))
                .map(UserRoleDto::fromValue)
                .findFirst();
    }
}
