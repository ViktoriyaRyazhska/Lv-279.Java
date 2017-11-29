///*
//* DefaultView
//*
//* Version 1.0-SNAPSHOT
//*
//* 27.11.17
//*
//* All rights reserved by DoubleO Team (Team#1)
//* */
//
//package ua.softserve.config;
//
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//public class LocaleConfiguration  extends WebMvcConfigurerAdapter {
//
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
////        resolver.setSuffix(".html");
//        return resolver;
//    }
//
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("/i18n/msg");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
////    @Bean
////    public LocaleResolver localeResolver(){
////        CookieLocaleResolver resolver = new CookieLocaleResolver();
//////        resolver.setDefaultLocale(new Locale("en"));
////        resolver.setCookieName("myLocaleCookie");
////        resolver.setCookieMaxAge(4800);
////        return resolver;
////    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//        interceptor.setParamName("mylocale");
//        registry.addInterceptor(interceptor);
//    }
//
//}