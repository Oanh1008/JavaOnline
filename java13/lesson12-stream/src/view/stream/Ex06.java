package view.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;



import bean.Dish;
import model.DataModel;

public class Ex06 {
	public static void main(String[] args) {
		List<Dish> menu = DataModel.getDishes();

		// Dish id: 1 2 3 2 3 4 5 6 7
		// result
		// loop
		
		List<Dish> rs= menu.stream()
						   .filter(dictictByKey(Dish::getKind))
						   .collect(Collectors.toList());
		rs.forEach(System.out::println);
	}
	/**
	 * 
	 * @param <C>  class type
	 * @param <P> property type
	 * @param function
	 * @return
	 */
	private static <C, P> Predicate<C> dictictByKey(Function<C, P> function) {
		Set<P> set = new HashSet<>();
		return dish -> set.add(function.apply(dish));

	}

}
