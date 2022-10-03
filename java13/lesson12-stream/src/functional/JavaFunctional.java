package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import utils.Printable;

public class JavaFunctional {
	public static void main(String[] args) {
List<String> elements = Arrays.asList("aaa", "bb", "cccc", "ddd");
		
		// TO get 'length' of each element in list of String
		// List<Integer> lengths = convert(elements, string -> string.length());
		List<Integer> lengths = convert(elements, new Function<String, Integer>() {
			public Integer apply(String t) {
				return t.length();
			};
		});
		
		Printable.printElement(lengths);
		
		
		// TO get first letter of each element in list of String
		// List<Character> firstLetters = convert(elements, text -> text.charAt(0));
		List<Character> firstLetters = convert(elements, new Function<String, Character>() {
			@Override
			public Character apply(String t) {
				// TODO Auto-generated method stub
				return t.charAt(0);
			}
		});
		
		Printable.printElement(firstLetters);
	}
	
	// Using Strategy Pattern - Functional Interface
	// element.length() || element.charAt(0) >>> behavior
	// Input: element(String)                     >> String
	// Output: length(Integer), chart0(Character) >> Generic Type: T
	
	// >>> Functional Interface: abstract method  >> R execute(String)
	private static <E,R> List<R> convert(List<E> elements, Function<E, R> function) {
		List<R> result = new ArrayList<>();
		for (E element: elements) {
			result.add(function.apply(element));
		}
		return result;
	}
	
	
	
	
	
	
}
