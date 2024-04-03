package sk.posam.fsa.jpa;
import jakarta.persistence.AttributeConverter;
import sk.posam.fsa.Race;

public class RaceTypeConverter implements AttributeConverter<Race, String>{
    @Override
    public String convertToDatabaseColumn(Race race) {
        if (race == null) {
            return null;
        }
        return race.name();
    }

    @Override
    public Race convertToEntityAttribute(String race) {
        if (race == null) {
            return null;
        }
        try {
            return Race.valueOf(race);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Invalid value for enum Race: " + race);
        }
    }
}
