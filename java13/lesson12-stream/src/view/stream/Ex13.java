package view.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import bean.Dish;
import model.DataModel;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu=DataModel.getDishes();
		
		if(menu.isEmpty()) {
			System.out.println("menu length should be greater than 0");
			return;
		}
		// find dish with maximum calories
		Dish rs=menu.stream().reduce(menu.get(0), (d1,d2)-> d1.getCalories()<d2.getCalories() ? d2:d1);
		Optional<Dish> rs1=menu.stream().max(Comparator.comparing(Dish::getCalories));
	
		System.out.println(rs);
		rs1.ifPresent(v->System.out.println(v));
		
		
		
	}
}
