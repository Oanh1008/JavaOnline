package view.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bean.Dish;
import model.DataModel;

public class Ex08 {
	public static void main(String[] args) {
		List<Dish> menu = DataModel.getDishes();
		// find the first 2 meat dishes;
		menu.stream()
			.filter(dish -> Dish.Kind.MEAT.equals(dish.getKind()))
			.limit(2)
			.forEach(System.out::println);

	}
}
