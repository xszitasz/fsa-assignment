package sk.posam.fsa.jpa;

import jakarta.persistence.AttributeConverter;
import sk.posam.fsa.UserRole;

public class UserRoleConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        return userRole.name();
    }

    @Override
    public UserRole convertToEntityAttribute(String userRole) {
        if (userRole == null) {
            return null;
        }
        try {
            return UserRole.valueOf(userRole);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Invalid value for enum UserRole: " + userRole);
        }
    }
}

