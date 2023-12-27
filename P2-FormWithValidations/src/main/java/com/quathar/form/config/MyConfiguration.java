package com.quathar.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import java.util.Locale;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    // <<-BEAN->>
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.ENGLISH);
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }

    // La aplicación debe estar en método POST según el enunciado
    // y para que se puedan enviar los archivos
    // por lo que aquí defino los interceptores pero no se pueden utilizar
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }

    @Bean
    public ThemeChangeInterceptor stylesChangeInterceptor() {
        ThemeChangeInterceptor tci = new ThemeChangeInterceptor();
        tci.setParamName("theme");
        return tci;
    }

    // <<-OVERRIDE->>
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(stylesChangeInterceptor());
    }

}
