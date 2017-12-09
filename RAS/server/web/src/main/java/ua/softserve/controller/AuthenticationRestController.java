package ua.softserve.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.config.DTO.JwtAuthenticationRequest;
import ua.softserve.config.DTO.JwtAuthenticationResponse;

@RestController
public class AuthenticationRestController {

    @RequestMapping(value = "api/auth", method = RequestMethod.POST)
    public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {
//        HttpHeaders headers=
        System.out.println(authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
        return new ResponseEntity<JwtAuthenticationResponse>(new JwtAuthenticationResponse("OK"), HttpStatus.OK);
    }

    @RequestMapping(value = "api/status", method = RequestMethod.GET)
    public ResponseEntity getUserStatus() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal.toString());
        return new ResponseEntity(HttpStatus.OK);
    }
}
