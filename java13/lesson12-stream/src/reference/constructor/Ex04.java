package reference.constructor;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import bean.Apple;
import functional.QuFunction;
import model.DataModel;


/**
 * Shorthand way to create instance if FI return Object
 * Using ClassName::new
 * + Supplier<R>          ==> R get()
 * + Function<T, R>       ==> R get(T t)
 * + ????????<T, X, R>    ==> R get(T, X)
 * + ????????<T, X, K, R> ==> R get(T, X, K)
 * + ????????<T, X, K, U, R> ==> R get(T, X, K, U)
 */

public class Ex04 {
	public static void main(String[] args) {
//		Supplier<Apple> spl01=  ()-> new Apple();    0 parameter
		Supplier<Apple> spl01=  Apple::new;
		Apple apl01= spl01.get();
		System.out.println(apl01);
		
		
//		Function<Integer, Apple> ftn02= id-> new Apple(id);     1 parameter
		Function<Integer, Apple> ftn02= Apple::new; // method reference
		
		Apple apl02= ftn02.apply(123);
		System.out.println(apl02);
		
		
		// BiFunction<T,X,Y>  2 parameters
//		BiFunction<Integer, String, Apple> bfn03= new BiFunction<>() {
//				public Apple apply(Integer id, String country) {
//					return new Apple(id, country);
//				};
//		};
//		BiFunction<Integer, String, Apple> bfn03= ( id,  country) -> new Apple(id, country);
		BiFunction<Integer, String, Apple> bfn03=Apple::new;
		Apple apl03= bfn03.apply(123,"VietNam");
		System.out.println(apl03);
		
		// Initial Function with 4 parameters
		
//		QuFunction<Integer, String, Double, String, Apple> qun04= new QuFunction<Integer, String, Double, String, Apple>() {
//			@Override
//			public Apple apply(Integer id, String color, Double weight, String country) {
//				// TODO Auto-generated method stub
//				return new Apple(id, color, weight, country);
//			}
//
//			
//		};
//		QuFunction<Integer, String, Double, String, Apple> qun04= 
//				( id,  color,  weight,  country)-> new Apple(id, color, weight, country);
		QuFunction<Integer, String, Double, String, Apple> qun04= Apple::new;
				
		Apple apl04= qun04.apply(123,"Yellow",258d,"VietNam");
		System.out.println(apl04);
		
		
		
		
	
}
}
