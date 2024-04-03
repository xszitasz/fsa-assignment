package sk.posam.fsa.controller;

import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.UserRole;
import sk.posam.fsa.mapper.AnimalMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sk.posam.fsa.Animal;
import sk.posam.fsa.rest.dto.AnimalDto;
import sk.posam.fsa.rest.dto.UserRoleDto;
import sk.posam.fsa.security.CurrentUserDetailService;
import sk.posam.fsa.service.AnimalService;

import java.util.Collections;
import java.util.List;

@RestController
public class AnimalController implements sk.posam.fsa.rest.api.AnimalsApi {

    private final AnimalService animalService;
    private final AnimalMapper animalMapper;
    private final CurrentUserDetailService currentUserDetailService;

    public AnimalController(AnimalService animalService, AnimalMapper animalMapper, CurrentUserDetailService currentUserDetailService) {
        this.animalService = animalService;
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
        animalService.create(animalEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @Override
    public ResponseEntity<List<AnimalDto>> getAnimalById(Long id) {
        Animal animalEntity = animalService.get(id);
        if (animalEntity != null) {
            AnimalDto animalDto = animalMapper.toAnimalDto(animalEntity);
            return ResponseEntity.ok().body(Collections.singletonList(animalDto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<AnimalDto> getAnimalByName(String name) {
        Animal animalEntity = animalService.get(name);
        if (animalEntity != null) {
            AnimalDto animalDto = animalMapper.toAnimalDto(animalEntity);
            return ResponseEntity.ok().body(animalDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
