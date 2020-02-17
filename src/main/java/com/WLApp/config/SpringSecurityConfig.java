package com.WLApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
				.antMatchers("/*", "/home", "/about", "/user", "/greeting").permitAll()
				.antMatchers("/greeting").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);

		// .antMatchers("/user/**").hasAnyRole("USER")
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
		// .withUser("user").password("password").roles("USER")
		// .and()
	}
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
			.authorizeRequests().anyRequest().fullyAuthenticated()
			.and()
			.formLogin().and().logout();
		//@formatter:on
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// {noop} docs: https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#core-services-in-memory-service
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
	}
	/*
	 * //Spring Boot configured this already.
	 * 
	 * @Override public void configure(WebSecurity web) throws Exception { web
	 * .ignoring() .antMatchers("/resources/**", "/static/**", "/css/**",
	 * "/js/**", "/images/**"); }
	 */

}
