package com.springmvc.model;

public class Student {
	private String fullName;
	private String age;
	private String country;
	private String language;
	private String[] systems;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String fullName, String age) {
		super();
		this.fullName = fullName;
		this.age = age;
	}
	
	public Student(String fullName, String age, String country) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.country = country;
	}
	
	public Student(String fullName, String age, String country, String language) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.country = country;
		this.language = language;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry() {
		return country;
	}
	public String getLanguage() {
		return language;
	
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String[] getSystems() {
		return systems;
	}
	
}
