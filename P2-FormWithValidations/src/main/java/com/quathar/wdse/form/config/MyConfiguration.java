package com.quathar.wdse.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

/**
 * <h1>My Configuration</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    // <<-BEANS->>
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.ENGLISH);
        slr.setDefaultLocale(new java.util.Locale("es"));
        return slr;
    }

    // The application must be in POST method according to the statement
    // and so that the files can be sent
    // so here I define the interceptors, but they cannot be used
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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(stylesChangeInterceptor());
    }

}
