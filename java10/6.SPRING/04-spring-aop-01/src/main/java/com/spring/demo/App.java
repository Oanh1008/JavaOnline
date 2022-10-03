package com.spring.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.MovieService;

public class App {
	private static final String path="aop-third.xml";
  public static void main(String[] args) {
    
	  
	  ConfigurableApplicationContext context= new ClassPathXmlApplicationContext(path);
	 // MovieService movieService= context.getBean("movieServiceProxy",MovieService.class);
	  MovieService movieService= context.getBean("movieService",MovieService.class);
	  movieService.printName();
	  
	  System.out.println("=============================");
	  movieService.printCatalog();
	  context.close();
  }
}
