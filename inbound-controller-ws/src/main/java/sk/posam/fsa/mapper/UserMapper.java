package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.UserRole;
import sk.posam.fsa.User;
import sk.posam.fsa.rest.dto.UserDto;
import sk.posam.fsa.rest.dto.UserRoleDto;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    private final CreditMapper creditMapper;

    public UserMapper(CreditMapper creditMapper) {
        this.creditMapper = creditMapper;
    }

    public UserDto toUserDto(User entity) {
        if (entity == null) { return null; }

        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setCreated(String.valueOf(entity.getCreated()));
        dto.setName(entity.getName());
        dto.setUserName(entity.getUserName());
        dto.setEmail(entity.getEmail());
        dto.setCredit(creditMapper.toCreditDto(entity.getCredit()));
        dto.setRole(UserRoleDto.valueOf(entity.getRole().name()));

        return dto;
    }

    public User toUserEntity(UserDto dto) {
        if (dto == null) { return null; }

        User entity = new User();
        entity.setId(dto.getId());
        entity.setCreated(LocalDateTime.parse(dto.getCreated()));
        entity.setName(dto.getName());
        entity.setUserName(dto.getUserName());
        entity.setEmail(dto.getEmail());
        entity.setCredit(creditMapper.toCreditEntity(dto.getCredit()));
        entity.setRole(UserRole.valueOf(dto.getName()));

        return entity;
    }
}
