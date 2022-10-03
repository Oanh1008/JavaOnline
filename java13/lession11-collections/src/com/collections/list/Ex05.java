package com.collections.list;

import java.util.ArrayList;
import java.util.List;

import bean.Item;

public class Ex05 {
	private static Item item;
	static {
		item= new Item(1, 1, "Store 1 - Item 1", 120);
	}
	public static void main(String[] args) {
		List<Item>items= getItems();
		// b1 duyệt các pt trong items
		// kiểm tra nếu có phần tử nào trong items ma "Equals" với item
		
		// must override to check contain by value
		System.out.println("is exist ?: "+items.contains(item)); // call Equals function
		
		printf(items);
		System.out.println("========================");
		
	}
	private static List<Item> getItems(){
		List<Item> items = new ArrayList<>();
		items.add(new Item(1, 1, "Store 1 - Item 1", 120));
		items.add(new Item(1, 2, "Store 1 - Item 2", 260));
		items.add(new Item(1, 3, "Store 1 - Item 3", 170));
		items.add(new Item(2, 3, "Store 2 - Item 3", 110));
		items.add(new Item(2, 4, "Store 2 - Item 4", 90));
		items.add(new Item(3, 5, "Store 3 - Item 5", 120));
		items.add(new Item(3, 6, "Store 3 - Item 6", 290));
		return items;
	}
	private static void  printf(List<Item> items) {
		for(Item item:items) {
			System.out.println(item);
		}
	}
}
