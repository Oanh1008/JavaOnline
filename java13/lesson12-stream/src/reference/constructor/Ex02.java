package reference.constructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import bean.Apple;
import model.DataModel;

/**
 Shorthand way to create instance if FI return Object
 using Classname::new
 Supplier<T>=> T get()
  * 
 */

public class Ex02 {
	public static void main(String[] args) {
//		Supplier<Apple> spl01=  ()-> new Apple();
		Supplier<Apple> spl01=  Apple::new;
		Apple apl01= spl01.get();
		System.out.println(apl01);
	
}
}
