package sk.posam.fsa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.posam.fsa.service.CreditFacade;
import sk.posam.fsa.service.CreditService;
import sk.posam.fsa.service.ReservationFacade;

@Configuration
public class CreditBeanConfiguration {
    @Bean
    public CreditFacade creditFacade(CreditRepository creditRepository, ReservationFacade reservationFacade){
        return new CreditService(creditRepository, reservationFacade);
    }
}
