package com.quathar.wdse.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * <h1>Main Application</h1>
 *
 * @since 2022-11-04
 * @version 1.0
 * @author Q
 */
@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    // <<-BEANS->>
    @Bean
    // By default, it returns LocaleResolver
    // Switches to SessionLocaleResolver
    // so that there is no type conflict
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(java.util.Locale.ENGLISH);
        return slr;
    }

    @Bean
    // Defines an interceptor (listener)
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    // We tell Spring to use the interceptor defined above
    // of name localeChangeInterceptor
    public void addInterceptors(InterceptorRegistry registry) {
        // Se añade al registro de interceptores definido anteriormente
        registry.addInterceptor(localeChangeInterceptor());
    }

}
