package com.collections.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Basic operations SOT: construct, add, for each, size, get, set, iterate(before 1.5), 
 * remove, contains internal build
 *
 * Data structure: Array
 */
public class Ex03 {
	public static void main(String[] args) {
		// empty arraylist >> Object[] elementData = {} as default
		List<String> statuses = new ArrayList<>(20);
		
		// internal build
		// add new element, return 1 new array from(elementData + newElement)
		// reality: first added element  elementData = new Object[DEFAULT_CAPACITY(10)]
		// size != length of elementData
		
		statuses.add("ORDER");
		statuses.add("PACKAGE");
		statuses.add("DELIVERY");
		statuses.add("RECEIVED");
		
		statuses.set(3, "BOOM");
		
		
		System.out.println("size: " + statuses.size());
		System.out.println("statusus[1]: " + statuses.get(1));
		for (String status: statuses) {
			System.out.println(status);
		}
		
		System.out.println("\n\\\\\\\\===================\\\\\\\\\\\\\\\\\n");
		
		// before 1.4: for index, iterate(value)
		// synchronous iteration
		
		// e.g
		// _
		// _ORDER
		// _PACKAGE
		// _DELIVERY
		// _BOOM
		// _
		Iterator<String> iterator = statuses.iterator();
		while(iterator.hasNext()) {
			String status = iterator.next();
			System.out.println("iterator: " + status);
		}
		
		// ====== contains, remove =======
		System.out.println("====== contains, remove =======");
		String word = "ORDER";
		// for (String status: statuses) {
		//	 if (word.equals(status)   ) {
		//	  	System.out.println("statues contains " + word);
		//	 }
		// }
		System.out.println("is existed ? " + statuses.contains(word));
		
		// statuses.remove(1);
		// statuses.remove("BOOM");
		
		statuses.removeIf(status-> status.startsWith("B"));
		
		for (String status: statuses) {
			System.out.println(status);
		}
		LinkedList<Integer>link= new LinkedList<Integer>();
		link.add(null);
	}
}