package com.spring.service;

import java.util.Arrays;
import java.util.List;

import com.spring.bean.Item;

public class ItemServiceImpl implements ItemService {

	public List<Item> getAll() {
		return Arrays.asList(new Item(1, "Item A1"), new Item(2, "Item A2"));
	}
	
	// XML -lifecycle
	public void init() {
		System.out.println(">> Do some initialization work");
	}
	public void destroy() {
		System.out.println(">> Do some cleaning work");
	}

}
