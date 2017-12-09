package com.cit;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class FinalProject6Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(FinalProject6Application.class, args);
	}
	
	
	/*These three beans allow us to implement localisation on all pages. Session Local resolver lets use set default locale
	, locale change interceptor lets use create a variable to be used in controller when describing the locale to change to,
	Add interceptor is to add the new locale change interceptor. Localised variables are marked as #{var} in thymeleaf.  
	See resources for two de and fr string property files. Select flag to change language on any html page.
	Make sure browser is not set to auto translate.*/
	@Bean
	public SessionLocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.UK);
	    return slr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
	}
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(localeChangeInterceptor());
	    }
	
}

