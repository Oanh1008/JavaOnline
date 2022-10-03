package view.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Dish;
import model.DataModel;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> numbers=Arrays.asList(1,3,2,6,2,3,1,4);
		
		// get unique elements from list of numbers >> 6 ,4
		
		// Option 1: Manually execute
				Map<Integer, Integer> statNbers = statistic(numbers);
				System.out.println(statNbers);

				System.out.println("================");
		
		
		//option2: using groupBy method in Stream
		
		List<Integer> uniqueNumbers=numbers.stream()
					.collect(Collectors.groupingBy(number->number, Collectors.counting())) // to Map<K,V>
					.entrySet() // Set<Entry<K,V>
					.stream()
					.filter(entry->entry.getValue()==1) // filter which have value==1
					.map(entry->entry.getKey()) // map rs
					.collect(Collectors.toList());
		System.out.println(uniqueNumbers);
		
		
		// select unique dish's calories from menu
		
		List<Dish>menu=DataModel.getDishes();
		List<Double>uniqueColories=menu.stream()
			.collect(Collectors.groupingBy(dish->dish.getCalories(), Collectors.counting()))
			.entrySet()
			.stream()
			.map(entry->entry.getKey())
			.distinct()
			.collect(Collectors.toList());
		System.out.println(uniqueColories);
	}
	private static Map<Integer, Integer> statistic(List<Integer> numbers) {
		// Entry >> K element, V number of appearance
		Map<Integer, Integer> counter = new HashMap<>();
		for (Integer number : numbers) {
			if (!counter.containsKey(number)) {
				counter.put(number, 1);
			} else {
				counter.replace(number, counter.get(number) + 1);
			}
		}
		return counter;
	}
}
