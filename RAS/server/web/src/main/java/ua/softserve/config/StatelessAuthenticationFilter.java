package ua.softserve.config;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.softserve.config.auth.TokenHandler;
import ua.softserve.persistence.entity.LoginUser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Component
public class StatelessAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenHandler tokenHandler;

    @Value("${app.jwt.tokenname}")
    private String tokenName;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies;
        if (httpServletRequest.getCookies() != null) {
            cookies = httpServletRequest.getCookies();
            Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(tokenName)).forEach(cookie -> {
                        Optional<UserDetails> userDetails = tokenHandler.parseUserFromToken(cookie.getValue());
                        if (tokenHandler.isTokenExpired(cookie.getValue())) {
                            cookie.setValue("");
                            cookie.setPath("/");
                            cookie.setMaxAge(0);
                            httpServletResponse.addCookie(cookie);
                            return;
                        }
                        httpServletResponse.addCookie(new Cookie(tokenName, tokenHandler.createTokenForUser((LoginUser) userDetails.get())));
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.get().getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
            );
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}