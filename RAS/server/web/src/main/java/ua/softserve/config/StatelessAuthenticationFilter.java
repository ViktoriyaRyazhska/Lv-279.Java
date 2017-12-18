package ua.softserve.config;

import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.softserve.config.auth.TokenAuthenticationService;
import ua.softserve.config.auth.TokenHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class StatelessAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;
    @Autowired
    private TokenHandler tokenHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("enter");
        Cookie[] cookies;
        System.out.println(Arrays.toString(httpServletRequest.getCookies()));
        if (httpServletRequest.getCookies()!=null) {
            cookies = httpServletRequest.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    Optional<UserDetails> userDetails = tokenHandler.parseUserFromToken(cookie.getValue());
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.get().getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("filter - " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
                }
            }
        }



        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }


//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//            throws IOException, ServletException {
//        try {
//            Authentication authentication = tokenAuthenticationService.getAuthentication((HttpServletRequest) req);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            chain.doFilter(req, res);
//        } catch (AuthenticationException | JwtException e) {
//            SecurityContextHolder.clearContext();
//            ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
}