package com.spring.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.configuration.AppConfig;
import com.spring.service.MovieService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		MovieService movieService= context.getBean("movieService",MovieService.class);
		movieService.addMovie();
//		movieService.updateMovie();
		
		
		
		context.close();
	}
}
