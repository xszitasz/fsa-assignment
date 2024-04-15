package sk.posam.fsa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.posam.fsa.service.ReservationFacade;
import sk.posam.fsa.service.ReservationService;

@Configuration
public class ReservationBeanConfiguration {
    @Bean
    public ReservationFacade reservationFacade(ReservationRepository reservationRepository) {
        return new ReservationService(reservationRepository);
    }
}
