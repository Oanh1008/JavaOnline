package view.dml;

import java.io.File;

import bean.Apple;
import utils.FileUtils;

public class Ex06 {
	private static final String pathname = "storage" 
			+ File.separator + "data" 
			+ File.separator 
			+ "inventory.txt";
	public static void main(String[] args) throws Exception {
		FileUtils.readlines(pathname,Apple::new).forEach(System.out::println);
	}
}
