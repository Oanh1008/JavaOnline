package view.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class Ex12 {
	public static void main(String[] args) {
		List<Integer>numbers= Arrays.asList(1,3,5,7,4,8,null);
		
		int a=numbers.stream().filter(number->number!=null)
			   .reduce(0, new BinaryOperator<Integer>() {
				 @Override
				public Integer apply(Integer t, Integer u) { 
					return t+u;
				}
			});
		
		int sum=numbers.stream().filter(Objects::nonNull)
				.reduce(0, Integer::sum);
		System.out.println("sum "+sum);
		
		int max=numbers.stream().filter(Objects::nonNull)
				.reduce(Integer.MIN_VALUE, Integer::max);
		System.out.println("max "+max);
		
		Optional<Integer> sum1=numbers.stream()
									.filter(Objects::nonNull)
									.reduce((t,u)->t+u);
		sum1.ifPresent(v->System.out.println("sum "+v));
		
		Optional<Integer> b=numbers.stream()
									.filter(Objects::nonNull)
									.max(Comparator.comparing(number->number));
		b.ifPresent(v->System.out.println("max" +v));
		
		
		// 1+ null
		// Integer ,null
		// intValue auto-unboxing
		
	}
}
