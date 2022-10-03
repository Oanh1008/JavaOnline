package view.stream;

import java.util.List;
import java.util.stream.Collectors;

import bean.Dish;
import bean.Dish.NameCaloriesParameter;
import model.DataModel;

public class Ex09 {
	public static void main(String[] args) {
		List<Dish> menu=DataModel.getDishes();
		//// new Dish("2", "D2", 620, Kind.OTHER, true) ==> (Name, Calories)
		
		List<NameCaloriesParameter> rs= menu.stream()
			.map(dish-> new NameCaloriesParameter(dish.getName(),dish.getCalories()))
			.distinct()
			.collect(Collectors.toList());
		rs.forEach(System.out::println);
	}
}
