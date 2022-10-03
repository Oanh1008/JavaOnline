package functional;

import java.util.function.Predicate;

/**
 * Function interface available in java
 * 
 * @author Oanhpv1008
 *
 */
public class FunctionalDemo {
	public static void main(String []a) {
	// predicate to check String length is greater than 8 or not
	Predicate<String> predicate= new Predicate<String>() {
		@Override
		public boolean test(String t) {
			// TODO Auto-generated method stub
			return t.length()>8;
		}
	};
	System.out.println(predicate.test("sdasd"));
	}
}
