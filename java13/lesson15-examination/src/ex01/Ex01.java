package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex01 {
	public static void main(String[] args) {
		List <Integer>numbers= Arrays.asList(1,2,3,4,5,6,5,5,3,1);
		
		numbers.stream()
			   .collect(Collectors.groupingBy(number->number,Collectors.counting()))
			   .entrySet()
			   .stream()
			   .filter(number->number.getValue()==1)
			   .map(number->number.getKey())
			   .collect(Collectors.toList())
			   .forEach(System.out::println);
		System.out.println("===========");
		numbers.stream()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet()
		.stream()
		.filter(number->number.getValue()==1)
		.map(number->number.getKey())
		.collect(Collectors.toList())
		.forEach(System.out::println);
	   
	      List <Integer>numbers1= Arrays.asList(5,7,9,10,20,9,7,11);
	      numbers1.stream()
		   .collect(Collectors.groupingBy(number->number,Collectors.counting()))
		   .entrySet()
		   .stream()
		   .filter(number->number.getValue()>1)
		   .map(number->number.getKey())
		   .collect(Collectors.toList())
		   .forEach(System.out::println);
		
	}
}
