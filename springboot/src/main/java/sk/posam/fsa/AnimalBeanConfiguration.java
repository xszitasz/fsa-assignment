package sk.posam.fsa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.posam.fsa.service.AnimalService;
import sk.posam.fsa.service.AnimalFacade;

@Configuration
public class AnimalBeanConfiguration {
    @Bean
    public AnimalFacade animalFacade(AnimalRepository animalRepository) {
        return new AnimalService(animalRepository);
    }
}
