package view.ddl;

import utils.FileUtils;

public class Ex02 {
	private static final String path="storage";
	public static void main(String[] args) {
		System.out.println(FileUtils.createNewFolder(path));
	}
}
