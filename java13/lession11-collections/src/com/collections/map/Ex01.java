package com.collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Require: Store list number of board car by City in VN
 * ---> HashMap	
 * @author Oanhpv1008
 *
 */
public class Ex01 {
	public static void main(String[] args) {
		Map<Integer, String> model= new HashMap<>();
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");
		
		model.put(74, "Quang ");
		// put , putIfAbsent, get, getOrDefault
		model.putIfAbsent(72, ""); // if exist,will not put
		// no order by,,distinct
		System.out.println("size: "+model.size());
		System.out.println(model.toString());
		
		// replace: set: put
		model.replace(57, "TTT");
		
		model.remove(75);
		System.out.println(model.toString());
		
		
		
		
	}
}
