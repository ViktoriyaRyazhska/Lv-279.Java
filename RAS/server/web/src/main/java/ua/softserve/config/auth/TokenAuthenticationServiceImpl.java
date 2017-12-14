package ua.softserve.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    @Value("${app.jwt.header}")
    private String header;

    private final TokenHandler tokenHandler;

    @Autowired
    TokenAuthenticationServiceImpl(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String authHeader = request.getHeader(header);
        if (authHeader == null)
            return null;

        return tokenHandler.parseUserFromToken(authHeader).map(LoginUserAuthentication::new).orElse(null);
    }
}
