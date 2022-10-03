package com.collections.map;

import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Ex02 {
	public static void main(String[] args) {
		Map<Integer, String> model= new HashMap<>();
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");
		
		System.out.println("size "+model.size());
		System.out.println("=======================");
		
		//1 iterate via key
		loopByKeys(model);
		
		//2 iterate via values
		loopByValues(model);
		
		//3 iterate via entries
		loopByEntries(model);
		
	}
	private static void loopByKeys(Map<Integer, String> model) {
		// key is unique
		//set<E> non-overlap, each element is unique
		
		Set<Integer>  keys= model.keySet();
		for(Integer key:keys) {
			System.out.println(key+ ", "+model.get(key));
		}
	}
	private static void loopByValues(Map<Integer, String> model) {
		// key is unique
		//set<E> non-overlap, each element is unique
		
		 Collection<String>values= model.values();
		for(String value:values) {
			System.out.println(value);
		}
	}
	private static void loopByEntries(Map<Integer, String> model) {
		// key is unique
		//set<E> non-overlap, each element is unique
	 Set<java.util.Map.Entry<Integer, String>>entries=	model.entrySet();
	
		for(java.util.Map.Entry<Integer, String> entry:entries) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}
	
}
