package sk.posam.fsa.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.posam.fsa.Reservation;
import sk.posam.fsa.ReservationStatus;
import sk.posam.fsa.rest.dto.ReservationDto;
import sk.posam.fsa.rest.dto.ReservationStatusDto;

import java.time.LocalDateTime;

@Component
public class ReservationMapper {
    private final UserMapper userMapper;
    private final AnimalMapper animalMapper;

    @Autowired
    public ReservationMapper(UserMapper userMapper, AnimalMapper animalMapper) {
        this.userMapper = userMapper;
        this.animalMapper = animalMapper;
    }

    public ReservationDto toReservationDto(Reservation entity) {
        if (entity == null) { return null; }

        ReservationDto dto = new ReservationDto();

        dto.setId(entity.getId());
        dto.setCreated(entity.getCreated().toString());
        dto.setStartTime(entity.getStartTime().toString());
        dto.setEndTime(entity.getEndTime().toString());
        dto.setStatus(ReservationStatusDto.valueOf(entity.getStatus().name()));
        dto.setUser(userMapper.toUserDto(entity.getUser()));
        dto.setAnimal(animalMapper.toAnimalDto(entity.getAnimal()));

        return dto;
    }

    public Reservation toReservationEntity(ReservationDto dto) {
        if (dto == null) { return null; }

        Reservation entity = new Reservation();

        entity.setId(dto.getId());
        entity.setCreated(LocalDateTime.parse(dto.getCreated()));
        entity.setStartTime(LocalDateTime.parse(dto.getStartTime()));
        entity.setEndTime(LocalDateTime.parse(dto.getEndTime()));
        entity.setStatus(ReservationStatus.valueOf(dto.getStatus().name()));

        entity.setUser(userMapper.toUserEntity(dto.getUser()));
        entity.setAnimal(animalMapper.toAnimalEntity(dto.getAnimal()));

        return entity;
    }
}