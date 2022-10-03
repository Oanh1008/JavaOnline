package com.collections.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Ex03 {
	/**
	 * HashMap ==== not maintain order of input elements
	 * TreeMap==== ascending 
	 * 			   descending
	 * LinkedHashMap === ensure order of input elements
	 * 
	 * 
	 * sorting by value ? manually
	 */
	public static void main(String[] args) {
		Map<Integer, String> model= new TreeMap<>(Comparator.reverseOrder());
		
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		
		
		print(model);
		
	}

	private static void print(Map<Integer, String> model) {
		// key is unique
		//set<E> non-overlap, each element is unique
	 Set<java.util.Map.Entry<Integer, String>>entries=	model.entrySet();
	
		for(java.util.Map.Entry<Integer, String> entry:entries) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}
	
}
