package view.primitive.stream;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		
		int[] digits= {1,2,3,4};
		int sum= Arrays.stream(digits).sum();
		System.out.println(sum);
	}
}
