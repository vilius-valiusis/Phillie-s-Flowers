package com.cit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
/*This class allows for adequate web security and handles the access to the admin dashboard. It also makes use of a utility class
we created called My access Denied Handler which handles exceptions related to authorisation.*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
    private AccessDeniedHandler accessDeniedHandler;
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
		    .loginPage("/login.html")		    
		.and()
		    .logout()
		    .logoutSuccessUrl("/index.html")		    
		.and()
		    .authorizeRequests()
		    .antMatchers("/dashboard/**").hasRole("ADMIN")		    
		.and()   
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		
		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().
		withUser("user").password("password").roles("USER").and().
		withUser("admin").password("admin").roles("ADMIN").and().
		withUser("a").password("a").roles("ADMIN").and().
		withUser("user1").password("password1").roles("ADMIN").and().
		withUser("user2").password("password2").roles("USER");
	}
}