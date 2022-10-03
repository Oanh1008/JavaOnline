package com.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bean.Item;
import model.DataProvider;
/**
 * Sorting with Collections#List
 * 
 * sort(List<T>): required: T implement Comparable<T> >> catch the error at compile time
 * sort(List<T>, Comparator<T>)
 * 
 * JAVA Collections - PRIOR TO JAVA 07
 * + Collections.sort(List<T>)
 * + Collections.sort(List<T>, Comparator<T>)
 * 
 * + JAVA 08 - NEW METHOD
 * + list.sort(Comparator<T>)     <<====>> Collections.sort(List<T>, Comparator<T>)
 */
public class Ex06 {
	public static void main(String[] args) {
		List<Item>items= DataProvider.getItems();
	//	Collections.sort(items);
//		Collections.sort(items,
//				Comparator.comparing(Item::getStoreId)
//				.thenComparing(Item::getItemId,Comparator.reverseOrder()
//						));
		items.sort(Comparator.comparing(Item::getStoreId)
				.thenComparing(Item::getItemId,Comparator.reverseOrder()));
		
		DataProvider.printf(items);
	}
	
}
