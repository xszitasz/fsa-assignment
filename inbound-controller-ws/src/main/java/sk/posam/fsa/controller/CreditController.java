package sk.posam.fsa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.Credit;
import sk.posam.fsa.Reservation;
import sk.posam.fsa.mapper.CreditMapper;
import sk.posam.fsa.rest.api.CreditsApi;
import sk.posam.fsa.rest.dto.CreditDto;
import sk.posam.fsa.security.CurrentUserDetailService;
import sk.posam.fsa.service.CreditFacade;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CreditController implements CreditsApi {
    private final CreditFacade creditFacade;
    private final CreditMapper creditMapper;
    private final CurrentUserDetailService currentUserDetailService;
    private final CreditFacade creditService;

    public CreditController(CreditFacade creditFacade,
                            CreditMapper creditMapper,
                            CurrentUserDetailService currentUserDetailService,
                            CreditFacade creditService) {
        this.creditFacade = creditFacade;
        this.creditMapper = creditMapper;
        this.currentUserDetailService = currentUserDetailService;
        this.creditService = creditService;
    }

    @Override
    public ResponseEntity<CreditDto> updateCreditCount(CreditDto creditDto) {
        try {
            LocalDateTime today = LocalDateTime.now();
            Long userId = currentUserDetailService.getFullCurrentUser().getId();
            List<Reservation> userReservations = creditService.getUserApprovedPastReservations(userId, today);

            int reservationCount = userReservations.size();
            int coefficient = creditService.calculateCoefficient(reservationCount);
            int newCount = reservationCount * coefficient;

            creditDto.setCount(newCount);
            Credit creditEntity = creditMapper.toCreditEntity(creditDto);
            creditFacade.update(creditEntity);

            return ResponseEntity.ok().body(creditDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
