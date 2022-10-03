package view.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Ex07 {
	public static void main(String[] args) {
		List<Integer>numbers=Arrays.asList(1,7,3,9,9,2,4);
		// get first largest numbers
		List<Integer> threeBestScore= numbers.stream()
											 .sorted(Comparator.comparing( Function.identity(),Comparator.reverseOrder()))
											 .limit(3)
											 .collect(Collectors.toList());
		threeBestScore.forEach(System.out::println);
	}
}
