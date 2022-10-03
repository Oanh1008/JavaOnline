package reference.method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import bean.Apple;
import model.DataModel;

/**
 * Input: List<Apple> inventory Write methods to 1. Get origin
 * countries(List<String>) of apples(List<Apple>) in inventory
 * 
 */

public class Ex01 {
	public static void main(String[] args) {
		List<Apple>inventory= DataModel.getApples();
		Set<String> countries= map(inventory,Apple::getCountry); // method reference (date type is Function)
		countries.forEach(System.out::println);
		
		List<String> countries1= map1(inventory, apple->apple.getCountry());
		countries.forEach(System.out::println);
	}
	private static <E,R> Set<R> map(List<E>inventory, Function<E, R> function){
		Set<R> rs= new HashSet<>();
		for(E apple:inventory) {
			rs.add(function.apply(apple));
		}
		return rs;
	}
	private static <E,R> List<R> map1(List<E>inventory, Function<E, R> function){
		List<R> rs= new ArrayList<>();
		for(E apple:inventory) {
			if(!rs.contains(function.apply(apple)))
				rs.add(function.apply(apple));
		}
		return rs;
	}
	
}
