package ua.softserve.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.softserve.validator.GroupValidator;
import ua.softserve.validator.impl.GroupValidatorImpl;

@Configuration
public class ServiceConfiguration {
    @Bean
    GroupValidator groupValidator() {
        return new GroupValidatorImpl();
    }
}
