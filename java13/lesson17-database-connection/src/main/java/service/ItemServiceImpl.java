package service;

import java.util.List;
import java.util.Objects;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService{
	private  ItemDao itemDao;
	public ItemServiceImpl() {
		itemDao= new ItemDaoImpl();
	}
	@Override
	public List<Item> findItemsByItemGroupName(String name) {
		Objects.requireNonNull(name,"Item cannot be null");
		return itemDao.findItemsByItemGroupName(name);
	}
}
