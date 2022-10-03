package view;

import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class ItemGroupView {
	private static ItemGroupService itemGroupService;
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}
	public static void main(String[] args) {
//		List<ItemGroup> itemGroups = itemGroupService.getAll();
//		itemGroups.forEach(group ->{
//			System.out.println(group);
//			List<Item> items= group.getItems();
//			items.forEach(System.out::println);
//			System.out.println();
//		});
		//itemGroupService.getItemByItemGroup().forEach(System.out::println);
		itemGroupService.secondLevelCache();
	}
}
