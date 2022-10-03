package view.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
 * 
 * 
 * 1st: is there any element that is divisible by 10 
 * 2nd: find the first element
 * that is divisible by 4 
 * 3nd: find the element that is divisible by 5 in the
 * list 4th: does all elements less than 100 -->> allMatch
 *  5th: does no elements
 * greater than 0 -->> noneMatch
 */
public class Ex11 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 4, 5, 8, 10, 4, 12);
		// 1st: is there any element that is divisible by 10
		boolean one= numbers.stream().allMatch(n->n%10==0);
		System.out.println("1: "+one);
		// 2nd: find the first element that is divisible by 4
		
		// Optional : reduce cause of exception
		// never NULL
		Optional<Integer> two=numbers.stream().filter(n->n%4==0).findFirst();
		two.ifPresent(t->System.out.println(t));
		// 3nd: find the element that is divisible by 5 in the list
		numbers.stream().filter(n->n%5==0).collect(Collectors.toList()).forEach(System.out::println);;
		// 4th: does all elements less than 100 -->> allMatch
		boolean four= numbers.stream().allMatch(n->n<100);
		System.out.println(four);
		// 5th: does no elements greater than 0 -->> noneMatc
		boolean five=numbers.stream().noneMatch(n->n<0);
		System.out.println(five);
	}
}
