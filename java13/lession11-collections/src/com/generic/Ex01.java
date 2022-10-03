package com.generic;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		Integer []numbers= {1,2,3,4,5};
		Double[] digits= {6d,7d,8d,9d,10d};
		String []months= {"Jan","Feb","Mar","Apr"};
		printfArr(numbers);
		printfArr(digits);
		printfArr(months);
		
		
	}
	// name: any name: E,T, M......
	// default: E is an Object
	private static <E extends Object> void printfArr(E[] arr) { // print each element in Array  by Generic
		for(E a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
}
