package view;

import java.util.Arrays;
import java.util.List;

import persistence.ItemGroup;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ItemDetailService;
import service.ItemDetailServiceImpl;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class BatchTransactionView {
	private static ItemGroupService itemGroupService;
	private static ItemDetailService itemDetailService;
	
	static {
		itemGroupService= new ItemGroupServiceImpl();
		itemDetailService = new ItemDetailServiceImpl();
	}
	public static void main(String[] args) {
		List<ItemGroup> itemGroups = Arrays.asList(
			new ItemGroup(114, "IG 111"),
			new ItemGroup(111, "IG 112"),
			new ItemGroup(115, "IG 113")
		);
//		int [] effectedRows= itemGroupService.save(itemGroups);
//		
//		Arrays.stream(effectedRows).forEach(System.out::println);
		
		System.out.println(itemDetailService.doTransfer());
	}
}
