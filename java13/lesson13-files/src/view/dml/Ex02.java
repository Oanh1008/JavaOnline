package view.dml;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import utils.FileUtils;

public class Ex02 {
	private static final String path = "storage" 
			+ File.separator + "data" 
			+ File.separator 
			+ "model.txt";
	public static void main(String[] args) {
		List<String>lines= Arrays.asList("Line 5--> Item01,Store 02",
										 "Line 6 --> Item02,Store 02");
		FileUtils.writeLine(lines, path);
	}
}
