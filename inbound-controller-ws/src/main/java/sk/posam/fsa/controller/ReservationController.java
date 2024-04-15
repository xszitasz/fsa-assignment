package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.Reservation;
import sk.posam.fsa.mapper.ReservationMapper;
import sk.posam.fsa.rest.dto.ReservationDto;
import sk.posam.fsa.rest.dto.UserRoleDto;
import sk.posam.fsa.security.CurrentUserDetailService;
import sk.posam.fsa.service.ReservationFacade;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReservationController implements sk.posam.fsa.rest.api.ReservationsApi{

    private final ReservationFacade reservationFacade;
    private final ReservationMapper reservationMapper;
    private final CurrentUserDetailService currentUserDetailService;

    public ReservationController(ReservationFacade reservationFacade, ReservationMapper reservationMapper, CurrentUserDetailService currentUserDetailService) {
        this.reservationFacade = reservationFacade;
        this.reservationMapper = reservationMapper;
        this.currentUserDetailService = currentUserDetailService;
    }

    @Override
    public ResponseEntity<ReservationDto> createReservation(ReservationDto reservationDto) {
        UserRoleDto userRole = currentUserDetailService.getCurrentUser().getRole();

        if (userRole != UserRoleDto.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

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
