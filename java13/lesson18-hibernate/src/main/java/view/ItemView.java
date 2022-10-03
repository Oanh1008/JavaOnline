package view;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemSizeRelation;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

public class ItemView {
	private static ItemService itemService;
	static {
		itemService = new ItemServiceImpl();
	}
	public static void main(String[] args) {
		List<Item> items= itemService.getAll();
		//items.forEach(System.out::println);
		System.out.println("=========");
		Item item0= items.get(0);
		List<ItemSizeRelation> itemSizeRelations=item0.getItemSizeRelations();
		itemSizeRelations.forEach(System.out::println);
		System.out.println("=======================");
		items.stream()
		     .collect(Collectors.groupingBy(Item::getItemGroup)).entrySet().forEach(System.out::println);
		
		System.out.println("\n\nGet Item by id");
		Optional<Item> optItem= itemService.get(5);
		if(optItem.isPresent()) {
			System.out.println(optItem.get());
		}
		
		System.out.println("\n\nFirst Level Cache");
		//itemService.firstLevelCache();
	}
}
