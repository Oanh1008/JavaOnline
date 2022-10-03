package com.collections.list;

import java.util.LinkedList;
import java.util.List;

public class Ex07 {
	public static void main(String[] args) {
		List<Integer> storeA=new LinkedList<>();
		storeA.add(1);
		storeA.add(2);
		storeA.add(3);
		storeA.add(4);
		storeA.add(5);
		
		
		List<Integer>storeB= new LinkedList<>();
		storeB.add(4);
		storeB.add(5);
		storeB.add(6);
		storeB.add(7);
		// add ALll
		List<Integer>combinedStoreItems= new LinkedList<>(storeA);
//		combinedStoreItems.addAll(storeA); //hop
//		combinedStoreItems.addAll(storeB);
//		combinedStoreItems.removeAll(storeB); // hieu
		combinedStoreItems.retainAll(storeB); // giao
		printf(combinedStoreItems);
		
		
	}
	private static void printf(List<Integer>items) {
		for(Integer item:items) {
			System.out.print(item+" ");
		}
	}
	
}
