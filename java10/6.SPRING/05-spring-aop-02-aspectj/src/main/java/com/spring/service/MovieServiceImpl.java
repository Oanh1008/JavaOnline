package com.spring.service;

public class MovieServiceImpl implements MovieService{

	@Override
	public void addMovie() {
		System.out.println("MovieService -- addMovie##");
	}

	@Override
	public void updateMovie() {
		System.out.println("MovieService -- updateMovie##");
	}

	@Override
	public void validateMovie() throws Exception {
		System.out.println("MovieService -- validateMovie##");
	}

	@Override
	public String getMovie() {
		return"MovieService -- getMovie##";
	}

}
