package ua.softserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.softserve.config.SecurityConfig;

@SpringBootApplication
public class TestacademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{TestacademyApplication.class, SecurityConfig.class}, args);
    }
}
