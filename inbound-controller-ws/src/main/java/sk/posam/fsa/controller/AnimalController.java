package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import sk.posam.fsa.Animal;
import sk.posam.fsa.mapper.AnimalMapper;
import sk.posam.fsa.rest.dto.AnimalDto;
import sk.posam.fsa.rest.dto.UserRoleDto;
import sk.posam.fsa.security.CurrentUserDetailService;
import sk.posam.fsa.service.AnimalFacade;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnimalController implements sk.posam.fsa.rest.api.AnimalsApi {

    private final AnimalFacade animalFacade;
    private final AnimalMapper animalMapper;
    private final CurrentUserDetailService currentUserDetailService;

    public AnimalController(AnimalFacade animalFacade, AnimalMapper animalMapper, CurrentUserDetailService currentUserDetailService) {
        this.animalFacade = animalFacade;
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
        animalFacade.create(animalEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @Override
    public ResponseEntity<List<AnimalDto>> getAllAnimals() {
        List<Animal> animals = animalFacade.getAll(); // Assuming getAll method is added to AnimalFacade
        List<AnimalDto> animalDtos = animals.stream()
                .map(animalMapper::toAnimalDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(animalDtos);
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
