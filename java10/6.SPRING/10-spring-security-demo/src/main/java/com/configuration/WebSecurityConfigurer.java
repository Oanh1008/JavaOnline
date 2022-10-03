package com.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		UserBuilder users= User.withDefaultPasswordEncoder();
//		// store in memory
//		auth.inMemoryAuthentication()
//				.withUser(users.username("john").password("test123").roles("EMLOYEE"))
//				.withUser(users.username("mary").password("test123").roles("EMLOYEE","MANAGER"))
//				.withUser(users.username("susan").password("test123").roles("EMLOYEE","ADMIN"));
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/user/register/**").permitAll()
			.antMatchers("/").hasRole("EMLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/system/**").hasRole("ADMIN")
		    .anyRequest()
		    .authenticated()
		   .and()
		    .formLogin() 
		    .loginPage("/login")// default / login GET
		    .loginProcessingUrl("/login")// def/ login POST
		    .permitAll()
		   .and()
		    .logout()
		    .permitAll()
		   .and()
		   	.exceptionHandling()
		   	.accessDeniedPage("/403");
		
		
	}
}
