package view;

import java.util.List;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

/**
 * 1/ Select * from LoaiHang
 * 
 * Dao,Service Design Pattern
 * 
 * 2/ SELECT * FROM LOAIHANG WHERE MaLH=?
 * @author Oanhpv1008
 *
 */
public class ItemGroupView {
	private static ItemGroupService itemGroupService;
	static {
		itemGroupService= new ItemGroupServiceImpl();
	}
	public static void main(String[] args) {
		System.out.println("6. Đếm số lượng mặt hàng theo loại hàng");
		itemGroupService.getItemsByItemGroup().forEach(System.out::println);
		
		System.out.println("SELECT * FROM LOAIHANG WHERE TenLH='Giày dép'");
		System.out.println(itemGroupService.getItemGroup("Giày dép")+"\n\n===========");
		System.out.println("UPDATE LOAIHANG SET TenLH= 'LH06' WHERE MaLH=6");
		System.out.println(itemGroupService.update(new ItemGroup(6, "LH06"))+"\n\n================================");
		
		
		System.out.println("SELECT FROM LOAIHANG WHERE MaLH=3");
		System.out.println(itemGroupService.getItemGroup(3)+"\n\n");
		System.out.println("save");
		//System.out.println(itemGroupService.save(new ItemGroup(6, "Áo ấm")));
		System.out.println("SELECT * FROM LOAIHANG");
		List<ItemGroup> itemGroups=itemGroupService.getAll();
		itemGroups.forEach(item->System.out.println(item));
		System.out.println("================");
	}
}
