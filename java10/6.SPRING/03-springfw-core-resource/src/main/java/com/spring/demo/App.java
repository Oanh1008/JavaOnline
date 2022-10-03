package com.spring.demo;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.bean.Item;
import com.spring.service.ClientService;
import com.spring.service.ItemService;

public class App {
	public static void main(String[] args) {
		String path="spring-beans.xml";
		path="classpath:spring-beans.xml";
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext(path);
		path="spring-beans.xml";
		ConfigurableApplicationContext context1= new FileSystemXmlApplicationContext(path);
		String []beans=context.getBeanDefinitionNames();
		
		
		
		
		
		context.close();
	}
}
