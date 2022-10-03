package com.spring.bean;

public class MovieCatalog {
	private final String catalog;
	public MovieCatalog(String catalog) {
		this.catalog=catalog;
	}
	public String getCat() {
		return catalog;
	}
		
	public void showMovie() {
		switch (catalog) {
		case "Action":{
			System.out.println("Hot movie >> Forever >> Action...");
			break;
		}
		case "Adventure":{
			System.out.println("Hot movie >> Avatar >> Adventure...");
			break;
		}
	}
}
}
