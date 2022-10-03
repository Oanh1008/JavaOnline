package view.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Dish;
import model.DataModel;

public class Ex05 {
	public static void main(String[] args) {
		List<Dish> menu= DataModel.getDishes();
		
		List<Double>colories=menu.stream()
								 .map(dish->dish.getCalories())
								 .distinct()
								 .collect(Collectors.toList());
		System.out.println(colories);
		
		List<Dish>rsList=menu.stream()
							 .distinct()
							 .collect(Collectors.toList());
		System.out.println(rsList);
		
		Set<Dish> rsSet=menu.stream()
							.collect(Collectors.toSet());
		System.out.println(rsSet);
	}

}
