package com.quathar.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    // <<-BEAN->>
    @Bean
    // Por defecto devuelve LocaleResolver
    // Se cambia a SessionLocaleResolver
    // para que no haya conflicto de tipos
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }

    @Bean
    // Define un interceptor (listener)
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    // <<-OVERRIDE->>
    @Override
    // Le indicamos a Spring que use el interceptor antes definido
    // de nombre localeChangeInterceptor
    public void addInterceptors(InterceptorRegistry registry) {
        // Se añade al registro de interceptores definido anteriormente
        registry.addInterceptor(localeChangeInterceptor());
    }

}
