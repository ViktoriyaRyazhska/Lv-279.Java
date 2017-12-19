package ua.softserve.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ua.softserve.persistence.entity.Authority;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final int MAX_AGE = 3600;

    @Value("${client_cross_origin}")
    private String url;

    @Autowired
    private UserDetailsService userService;

    @Bean
    public StatelessAuthenticationFilter statelessAuthenticationFilter(){
        return new StatelessAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/reports/check_list_by_groups")
                    .hasAnyAuthority(Authority.ITA_COORDINATOR.toString())
                .antMatchers("/reports/itaTacticalPlanByGroupStage")
                    .hasAnyAuthority(Authority.ITA_COORDINATOR.toString(),Authority.SOFTSERVE_PM.toString(),Authority.RECRUITER.toString())
                .antMatchers("/marks")
                    .hasAnyAuthority(Authority.ITA_COORDINATOR.toString(),Authority.RECRUITER.toString(),Authority.SOFTSERVE_PM.toString(),Authority.TEACHER.toString(),
                            Authority.EXPERT.toString(),Authority.INTERVIEWER.toString())
                .antMatchers("/students/**")
                    .hasAnyAuthority(Authority.ITA_COORDINATOR.toString(),Authority.RECRUITER.toString(),Authority.SOFTSERVE_PM.toString())
                .antMatchers("/academy/**")
                    .hasAnyAuthority(Authority.ITA_COORDINATOR.toString(),Authority.ITA_ADMIN.toString())
                .anyRequest().permitAll();
        http
                .addFilterBefore(statelessAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http
                .headers().cacheControl();

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public FilterRegistrationBean registration(StatelessAuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public WebMvcConfigurer CorsConfig() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(url)
                        .allowCredentials(true)
                        .allowedHeaders("Access-Control-Allow-Credentials", "Content-Type", "Access-Control-Allow-Headers", "X-Requested-With", "Origin", "Accept")
                        .allowedMethods("PUT", "DELETE", "GET", "POST")
                        .maxAge(MAX_AGE);
            }
        };
    }


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
