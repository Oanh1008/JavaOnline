package view.dml;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.List;

import utils.FileUtils;

public class Ex04 {
	private static final String path = "storage" 
			+ File.separator + "data" 
			+ File.separator 
			+ "model.txt";
	public static void main(String[] args) {
		List<String>lines=FileUtils.readLines(path);
		lines.forEach(System.out::println);
		
	}
}
