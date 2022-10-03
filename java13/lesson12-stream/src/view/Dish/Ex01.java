package view.Dish;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import bean.Dish;
import model.DataModel;

/**
 * Input:       List<Dish> menu
 * Requirement: Get dishes which have calories greater than 400
 *            : Generic for any condition, any class
 * Output:      List<Dish> result
 *
 */
public class Ex01 {
	public static void main(String[] args) {
		List<Dish>menu=DataModel.getDishes();
		// B1: Convert DATA_SOURCE to Stream
				//   : List<Dish> --> Stream<Dish>
				// B2: Call methods(API) from stream to handle requirements
				//   : stream methods which are written as Builder Pattern
				//   : Item item = Item.builder().id().name().city();
				//   : Stream<X> stream = stream.methodA().methodB()
				// B3: Return List<Dish>
		
		
		List<String>name=menu.stream().filter(t->t.getCalories()>400).map(a->a.getName()).collect(Collectors.toList());
		List<Dish>colories=menu.stream().filter(t->t.getCalories()>400).collect(Collectors.toList());
		colories.forEach(System.out::println);
		name.forEach(System.out::println);
	}
}
