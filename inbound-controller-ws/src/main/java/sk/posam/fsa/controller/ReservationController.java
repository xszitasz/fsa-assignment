package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.Reservation;
import sk.posam.fsa.mapper.ReservationMapper;
import sk.posam.fsa.mapper.UserMapper;
import sk.posam.fsa.rest.dto.ReservationDto;
import sk.posam.fsa.rest.dto.ReservationStatusDto;
import sk.posam.fsa.rest.dto.UserDto;
import sk.posam.fsa.rest.dto.UserRoleDto;
import sk.posam.fsa.security.CurrentUserDetailService;
import sk.posam.fsa.service.ReservationFacade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReservationController implements sk.posam.fsa.rest.api.ReservationsApi{

    private final ReservationFacade reservationFacade;
    private final ReservationMapper reservationMapper;
    private final CurrentUserDetailService currentUserDetailService;
    private final UserMapper userMapper;

    public ReservationController(ReservationFacade reservationFacade, ReservationMapper reservationMapper, CurrentUserDetailService currentUserDetailService, UserMapper userMapper) {
        this.reservationFacade = reservationFacade;
        this.reservationMapper = reservationMapper;
        this.currentUserDetailService = currentUserDetailService;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<ReservationDto> createReservation(ReservationDto reservationDto) {
        if (currentUserDetailService.getCurrentUser().getRole() != UserRoleDto.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        UserDto userDto = userMapper.toUserDto(currentUserDetailService.getFullCurrentUser());

        reservationDto.setStatus(ReservationStatusDto.PENDING);
        reservationDto.setUser(userDto);
        reservationDto.setCreated(String.valueOf(LocalDateTime.now()));

        Reservation reservationEntity = reservationMapper.toReservationEntity(reservationDto);
        reservationFacade.create(reservationEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @Override
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        List<ReservationDto> reservations = reservationFacade.getAll().stream()
                .map(reservationMapper::toReservationDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservations);
    }

    @Override
    public ResponseEntity<ReservationDto> getReservationById(Long id) {
        Reservation reservation = reservationFacade.get(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservationMapper.toReservationDto(reservation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
