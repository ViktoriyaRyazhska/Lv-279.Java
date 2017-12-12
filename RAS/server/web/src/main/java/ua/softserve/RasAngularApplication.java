package ua.softserve;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.softserve.util.encrypt.aes.Encryptor;


@SpringBootApplication
public class RasAngularApplication {
    public static void main(String[] args) {
        Encryptor.init();
        SpringApplication.run(RasAngularApplication.class, args);
    }
}
