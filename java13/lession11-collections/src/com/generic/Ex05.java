package com.generic;

import java.util.function.Predicate;

public class Ex05 {
	public static void main(String[] args) {
		IList<Integer> numbers = new CustomList<Integer>();
		
		numbers.add(5);
		numbers.add(7);
		numbers.add(12);
		numbers.add(20);
		
		int count =numbers.count(new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				return t%7==0;
			}
		});
		int count1 =numbers.count(t->t%5==0);
		System.out.println("number of power of 5 :"+ count1);
	}
}
