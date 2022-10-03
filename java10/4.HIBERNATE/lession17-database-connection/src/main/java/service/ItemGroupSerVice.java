package service;

import java.util.List;
import java.util.stream.Collectors;

// service
//1. get data from dao layer
//2. process logic
//3 return data to view

import dao.ItemGroupDao;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import persistence.ItemGroupRawData;

public class ItemGroupSerVice {
	private ItemGroupDao itemGroupDao;
	
	public ItemGroupSerVice() {
		itemGroupDao= new ItemGroupDao();
	}
	// select all Item
	public List<ItemGroup> getAll(){
		return itemGroupDao.getAll();
	}
	// select item by each ID
	public ItemGroup  getItemGroups(int id){
		return itemGroupDao.getItemGroups(id);
	}
	// select item by each Name
	public List<ItemGroup> getItemGroups(String name){
		return itemGroupDao.getItemGroups(name);
	}
	// insert one row
	public boolean save(ItemGroup itemGroup) {
		return itemGroupDao.save(itemGroup);
	}
	// insert many rows
	public boolean addBatch(List<ItemGroup> itemGroups) {
		return itemGroupDao.addBatch(itemGroups);
	}
	
	
	// 3...no idea to comment
	public List<ItemGroupDto> getItemGroups(){
		return itemGroupDao.getItemGroups()
						   .stream()
						   .map(ItemGroupDto::new)
						   .collect(Collectors.toList());
		
	}
	
}
