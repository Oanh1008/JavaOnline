package service;

import java.util.List;

import dao.ItemGroupDao;
import persistence.ItemGroup;
/**
 * 1. Get data from DAO layer
 * 2. Process logic
 * 3. Return data to VIEW
 * @author Oanhpv1008
 *
 */

public class ItemGroupService {
	
	private ItemGroupDao itemGroupDao;
	public ItemGroupService() {
		itemGroupDao= new ItemGroupDao();
	}
	public List<ItemGroup> getItemGroup(){
		return itemGroupDao.getAll();
	}
	
	public ItemGroup getItemGroup(int id){
		return itemGroupDao.getItemGroup(id);
	}
	
	public List<ItemGroup> getItemGroup(String name){
		return itemGroupDao.getItemGroup(name);
	}
	
	public boolean save(ItemGroup itemGroup) {
		return itemGroupDao.save(itemGroup);
	}
	}
