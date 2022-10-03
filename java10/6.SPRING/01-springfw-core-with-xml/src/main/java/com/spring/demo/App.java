package com.spring.demo;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bean.Item;
import com.spring.service.ClientService;
import com.spring.service.ItemService;

public class App {
	public static void main(String[] args) {
		// Plain Object
		//rgs Configuration metadata - defined bean and dependencies
		// construct spring ioc
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
		String []beans=context.getBeanDefinitionNames();
		
		Item itemA= context.getBean("itemA",Item.class);
		Item itemB= context.getBean("itemB",Item.class);
		Item itemC= context.getBean("itemC",Item.class);
		System.out.println(itemA);
		System.out.println(itemB);
		System.out.println(itemC);
		
		System.out.println(Arrays.toString(beans));
		
		ClientService clientService= context.getBean("clientService",ClientService.class);
		System.out.println(clientService);
		clientService.clientInfo();
		
		System.out.println("///////////////------bean scope lifecycle----------------///////////////////////////");
		ItemService serviceA= context.getBean("itemService", ItemService.class);
		ItemService serviceB= context.getBean("itemService", ItemService.class);
		System.out.println(serviceA);
		System.out.println(serviceB);
		context.close();
	}
}
