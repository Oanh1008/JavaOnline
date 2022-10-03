package view.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import  static utils.Printable.*;

public class Ex10 {
	public static void main(String[] args) {
		// FlatMap ->array ,List
		Integer[][] numbers = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		Integer[] rs = Arrays.stream(numbers) // Stream<Integer[]>
				.flatMap(e -> Arrays.stream(e)) // Stream<integer>  // Arrays::stream
				.sorted()
				.toArray(Integer[]::new); // Integer[]
		
		System.out.println(Arrays.toString(rs));
		
		
		List<List<String>> cards=Arrays.asList(
				Arrays.asList("2 cơ","3 rô","4 chuồn"),

				Arrays.asList("2 rô","3 rô","4 rô"),
				Arrays.asList("2 cơ","3 chuồn","4 cơ")
				);
		cards.stream()  // Stream<List<String>>
			 .flatMap(card-> card.stream()) //Stream<String>
			 .collect(Collectors.toList())
			 .forEach(System.out::println);;
			 
		String remainingCards=	 cards.stream()  // Stream<List<String>>
			 .flatMap(List::stream) //Stream<String>
			 .collect(Collectors.joining(", "));
		System.out.println(remainingCards);
			 
	}

}
