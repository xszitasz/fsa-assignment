package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import sk.posam.fsa.Animal;
import sk.posam.fsa.Reservation;
import sk.posam.fsa.mapper.AnimalMapper;
import sk.posam.fsa.rest.api.AnimalsApi;
import sk.posam.fsa.rest.dto.AnimalDto;
import sk.posam.fsa.rest.dto.UserRoleDto;
import sk.posam.fsa.security.CurrentUserDetailService;
import sk.posam.fsa.service.AnimalFacade;
import sk.posam.fsa.service.ReservationFacade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class AnimalController implements AnimalsApi {

    private final AnimalFacade animalFacade;
    private final ReservationFacade reservationFacade;
    private final AnimalMapper animalMapper;
    private final CurrentUserDetailService currentUserDetailService;

    public AnimalController(AnimalFacade animalFacade, ReservationFacade reservationFacade, AnimalMapper animalMapper, CurrentUserDetailService currentUserDetailService) {
        this.animalFacade = animalFacade;
        this.reservationFacade = reservationFacade;
        this.animalMapper = animalMapper;
        this.currentUserDetailService = currentUserDetailService;
    }

    @Override
    public ResponseEntity<Void> createAnimal(AnimalDto animalDto) {
        UserRoleDto userRole = currentUserDetailService.getCurrentUser().getRole();

        if (userRole != UserRoleDto.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Animal animalEntity = animalMapper.toAnimalEntity(animalDto);
        animalEntity.setId(null);
        animalFacade.create(animalEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @Override
    public ResponseEntity<List<AnimalDto>> getAllAnimals() {
        List<Animal> animals = animalFacade.getAll();
        List<AnimalDto> animalDtos = animals.stream()
                .map(animalMapper::toAnimalDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(animalDtos);
    }

    @Override
    public ResponseEntity<List<AnimalDto>> getAllAnimalsWithinTimeRange(String startTime, String endTime) {
        LocalDateTime startDateTime = LocalDateTime.parse(startTime);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime);

        List<Animal> allAnimals = animalFacade.getAll();
        List<Reservation> allReservations = reservationFacade.getAll();

        List<Animal> availableAnimals = allAnimals.stream()
                .filter(animal -> isAnimalAvailable(allReservations, startDateTime, endDateTime, animal))
                .toList();

        List<AnimalDto> availableAnimalDtos = availableAnimals.stream()
                .map(animalMapper::toAnimalDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(availableAnimalDtos);
    }

    private boolean isAnimalAvailable(List<Reservation> reservations, LocalDateTime startTime, LocalDateTime endTime, Animal animal) {
        for (Reservation reservation : reservations) {
            LocalDateTime reservationStartTime = reservation.getStartTime();
            LocalDateTime reservationEndTime = reservation.getEndTime();

            // Check if the reservation overlaps with the specified time range
            if (startTime.isBefore(reservationEndTime) && endTime.isAfter(reservationStartTime) && Objects.equals(animal.getId(), reservation.getAnimal().getId())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ResponseEntity<AnimalDto> getAnimalById(Long id) {
        Animal animalEntity = animalFacade.get(id);
        if (animalEntity != null) {
            AnimalDto animalDto = animalMapper.toAnimalDto(animalEntity);
            return ResponseEntity.ok().body(animalDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
