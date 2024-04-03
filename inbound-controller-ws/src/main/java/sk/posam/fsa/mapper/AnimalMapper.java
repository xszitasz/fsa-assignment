package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.Animal;
import sk.posam.fsa.Race;
import sk.posam.fsa.rest.dto.AnimalDto;
import sk.posam.fsa.rest.dto.RaceDto;

@Component
public class AnimalMapper {
    public AnimalDto toAnimalDto(Animal entity) {
        if (entity == null) {
            return null;
        }

        AnimalDto dto = new AnimalDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRace(RaceDto.valueOf(entity.getRace().name()));
        return dto;
    }

    public Animal toAnimalEntity(AnimalDto dto) {
        if (dto == null) {
            return null;
        }

        Animal entity = new Animal();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRace(Race.valueOf(dto.getRace().name()));
        return entity;
    }
}
