package com.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.aspect.MovieLogAspect;
import com.spring.service.MovieService;
import com.spring.service.MovieServiceImpl;

@Configuration
public class MovieAspectConfig {

	@Bean
	public MovieService movieService() {
		// join point
		return new MovieServiceImpl();
	}
	@Bean
	public MovieLogAspect movieLogAspect() {
		// point cut , advice
		return new MovieLogAspect();
	}
}
