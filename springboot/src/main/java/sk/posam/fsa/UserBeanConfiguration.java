package sk.posam.fsa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.posam.fsa.service.UserService;
import sk.posam.fsa.service.UserFacade;

@Configuration
public class UserBeanConfiguration {
    @Bean
    public UserFacade userFacade(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
