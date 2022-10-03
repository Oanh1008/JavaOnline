package view;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import persistence.ItemGroup;
import service.ItemGroupSerVice;

public class App {
	private static ItemGroupSerVice itemGroupSerVice;
	
	
	// initial Object... convention
	static {
		itemGroupSerVice = new ItemGroupSerVice();
	}
	public static void main(String[] args) {

		List<ItemGroup> itGroupAll= itemGroupSerVice.getAll();
		itGroupAll.forEach(System.out::println);
		System.out.println("===================================");
		ItemGroup itgsById= itemGroupSerVice.getItemGroups(3);
		System.out.println(itgsById);
		System.out.println("===================================");
		List<ItemGroup> itgsByName= itemGroupSerVice.getItemGroups("xyz");
		itgsByName.forEach(System.out::println);
		System.out.println("===================================");
		
//		itemGroupSerVice.save(new ItemGroup(19, "Groupitem19"));
//		 itemGroupSerVice.getAll().forEach(System.out::println);;
		
		// 3
		itemGroupSerVice.getItemGroups().forEach(System.out::println);
		
		// 7
		itemGroupSerVice.addBatch(Arrays.asList(new ItemGroup(101,"ItemGroup101"),new ItemGroup(102,"ItemGroup102") ));
		 itemGroupSerVice.getAll().forEach(System.out::println);
		 try {
			MessageDigest md= MessageDigest.getInstance("MD5");
		System.out.println(md.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
