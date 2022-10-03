package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.spring.bean.MovieCatalog;

@Configuration
public class MoiveConfig {
	
	@Bean
	@Primary
	@Scope("prototype")
	public MovieCatalog action() {
		return new MovieCatalog("Action");
	}
	@Bean
	public MovieCatalog adventure() {
		return new MovieCatalog("Adventure");
	}
}
