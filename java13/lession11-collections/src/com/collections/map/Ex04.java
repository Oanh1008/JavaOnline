package com.collections.map;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Ex04 {
	/**
	
	 * 
	 * 
	 * sorting by value ? manually
	 * normally : sort >> return  void
	 * 					>>> return SortedMap
	 */
	public static void main(String[] args) {
		Map<Integer, String> model= new HashMap<>();
		
		model.put(75, "DThua Thien Hue");
		model.put(74, "BQuang Tri");
		model.put(92, "CQuang Nam");
		model.put(43, "ADa Nang");
		
		
		print(model);
		Map<Integer, String> sorted= sort(model);
		System.out.println("=========");
		print(sorted);
		
	}
	private static Map<Integer, String> sort(Map<Integer, String> model){
		
		// Set<E> does not support sorting
		
		Set<java.util.Map.Entry<Integer,String>> elements= model.entrySet();
		
		
		//2 Convert Set<Entry> to List<entry> : support sorting
		List<java.util.Map.Entry<Integer,String>> sortedList= new ArrayList<>(elements);
		
		
		// 3 Sort List<Entry> by Entry (Key, Value)
//		sortedList.sort(new Comparator<java.util.Map.Entry<Integer,String>>() {
//			@Override
//			public int compare(java.util.Map.Entry<Integer, String> o1, java.util.Map.Entry<Integer, String> o2) {
//				// TODO Auto-generated method stub
//				return o1.getValue().compareTo(o2.getValue());
//			}
//		});
//		sortedList.sort((o1,o2)->o1.getValue().compareTo(o2.getValue())); lambda
//		sortedList.sort(Comparator.comparing(java.util.Map.Entry::getValue));
		sortedList.sort(java.util.Map.Entry.comparingByValue());
		// 4 put elements from sortedList to sortedMap
		Map<Integer, String> sortedMap= new LinkedHashMap<>();
		// 1 get all entries in map, return Set<Entry>
		for(java.util.Map.Entry<Integer,String> e:sortedList) {
			sortedMap.put(e.getKey(), e.getValue());
		}
		return sortedMap;
		
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
