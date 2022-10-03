package view.ddl;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class Ex04 {
	private static final String path="storage"+File.separator+"download";
	public static void main(String[] args) {
		File dir= new File(path);
		if(dir.exists()) {
			// delete non-txt files from this folder
			//filter
			//delete
		 
		 File[]files=	dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stubstri
				String fileName=file.getName();
				String extension=file.getName().substring(fileName.lastIndexOf(".")+1);
				return !"txt".equals(extension);
				
				
			}
		});
		 Arrays.stream(files)
		 	   .forEach(file->file.delete());
		 
		}
		System.out.println("====finished========");
	}
	
}
