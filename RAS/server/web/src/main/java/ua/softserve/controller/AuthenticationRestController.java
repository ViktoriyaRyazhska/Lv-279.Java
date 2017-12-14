package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.softserve.config.auth.TokenHandler;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.service.SecurityContextService;

@RestController
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final TokenHandler tokenHandler;
    private final SecurityContextService securityContextService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, TokenHandler tokenHandler,
            SecurityContextService securityContextService) {
        this.authenticationManager = authenticationManager;
        this.tokenHandler = tokenHandler;
        this.securityContextService = securityContextService;
    }

    @RequestMapping(value = "api/auth", method = RequestMethod.POST)
    public AuthResponse createAuthenticationToken(@RequestBody AuthParams authenticationRequest) {
        final UsernamePasswordAuthenticationToken loginToken = authenticationRequest.toAuthenticationToken();
        final Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return securityContextService.currentUser().map(u -> {
            final String token = tokenHandler.createTokenForUser(u);
            return new AuthenticationRestController.AuthResponse(token);
        }).orElse(new AuthenticationRestController.AuthResponse(HttpStatus.FORBIDDEN));
    }

    private static final class AuthParams {
        private String username;
        private String password;

        public AuthParams() {
        }

        public AuthParams(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        UsernamePasswordAuthenticationToken toAuthenticationToken() {
            return new UsernamePasswordAuthenticationToken(username, password);
        }
    }

    private static final class AuthResponse {
        private String token;
        private HttpStatus httpStatus;

        public AuthResponse() {
        }

        public AuthResponse(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}