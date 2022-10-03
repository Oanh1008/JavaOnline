package com.spring.demo;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.MovieRecommend;
import com.spring.config.AppConfig;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		printBeans(context);
		MovieRecommend recommender= context.getBean("movieRecommend",MovieRecommend.class);
		recommender.recommend();
	}
	
	private static void printBeans(ApplicationContext context) {
		String[] beans= context.getBeanDefinitionNames();

		for(String bean:beans) {
			System.out.println(bean);
		}
		System.out.println("============/////////////=========");
	}
}
