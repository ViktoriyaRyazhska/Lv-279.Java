package ua.softserve.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.LoginUser;

import java.util.Optional;

@Component
public interface TokenHandler {

    Optional<UserDetails> parseUserFromToken(String token);

    String createTokenForUser(LoginUser user);

    Boolean isTokenExpired(String token);

}
