package ua.softserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ua.softserve.*")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/mycss/**")
                .addResourceLocations("/static/css/");
        registry
                .addResourceHandler("/bs/css/**")
                .addResourceLocations("/static/css/");
        registry
                .addResourceHandler("/bs/js/**")
                .addResourceLocations("/static/js/");
        registry
                .addResourceHandler("/TRIGER/**")
                .addResourceLocations("/style/");


    }


}
