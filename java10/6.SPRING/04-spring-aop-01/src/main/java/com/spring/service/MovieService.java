package com.spring.service;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;

// step1: join point classs
public class MovieService {
	private String name;
	private String catalog;
	public void setName(String name) {
		this.name = name;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	//join point method
	public void printName() {
		System.out.println("MovieService printName >> "+ name);
	}
	public void printCatalog() {
		System.out.println("MovieService printCatalog >> "+ catalog);
	}
	
}
