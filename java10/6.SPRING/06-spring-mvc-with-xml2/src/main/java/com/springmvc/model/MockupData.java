package com.springmvc.model;

public class MockupData {
	private MockupData () {
		
	}
	public static String[] getCountries() {
		return new String[] {
				"Brazil","France","Germany","India"
		};
	}
	public static String[] getLanguages() {
		return new String[] {
				"Swing Desktop App","Spring MVC WepApp","Spring Boot","JPA/Hibernate"
		};
	}
	public static String[] getOS() {
		return new String[] {
				"Window","MacOs","Linix","Unix"
		};
	}
}
