package ua.softserve.config.auth;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.persistence.repo.LoginUserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.ZonedDateTime;
import java.util.*;

@Component
public final class TokenHandlerImpl implements TokenHandler {

    private static final String CLAIM_KEY_AUTHORITY = "authority";
    private static final int MILLISECONDS_TO_SECONDS = 1000;
    private final String secret;
    private final LoginUserRepository userRepository;

    @Value("${app.jwt.expiration}")
    private Long expiration;

    @Autowired
    public TokenHandlerImpl(@Value("${app.jwt.secret}") String secret, LoginUserRepository userRepository) {
        this.secret = secret;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDetails> parseUserFromToken(String token) {
        final String subject = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        final LoginUser user = userRepository.findOne(Integer.valueOf(subject));
        return Optional.ofNullable(user);
    }

    @Override
    public String createTokenForUser(LoginUser user) {
        return Jwts.builder().setClaims(generateClaims(user))
                .setSubject(String.valueOf(user.getId()))
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(generateExpirationDate())
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * MILLISECONDS_TO_SECONDS);
    }

    private Map<String, Object> generateClaims(LoginUser user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_AUTHORITY, user.getAuthorities());
        return claims;
    }

    private Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            created = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
        } catch (NullPointerException e) {
            created = null;
        }
        return created;
    }

    public Boolean isTokenExpired(String token) {
        final Date tokenExpiration = getCreatedDateFromToken(token);
        return tokenExpiration.before(new Date());
    }

}
