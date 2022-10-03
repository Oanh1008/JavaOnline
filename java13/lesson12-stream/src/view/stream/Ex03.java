package view.stream;

import java.util.Arrays;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		List<Integer> numbers=Arrays.asList(1,3,2,6,2,3,1,4);
		
		// find all even elenments
		/*Integer[] result = numbers.stream() // Stream<Integer>
		.filter(number -> number % 2 == 0) // Stream<Integer>
		.toArray(new IntFunction<Integer[]>() {
			@Override
			public Integer[] apply(int length) {
				return new Integer[length];
			}
		});*/
		
		
		Integer[]rs=numbers.stream()
			   .filter(n->n%2==0)
			   .toArray(lenght->new Integer[lenght]);
		
		
		// length -> new Integer[length] ->constructor reference
		Integer[]rs1=numbers.stream()
				.filter(n->n%2==0)
				.distinct()
				.toArray(Integer[]::new);
		
		
		
		
		
		Arrays.stream(rs1)
			  .forEach(System.out::println); // Arrays to Stream
	}
}
