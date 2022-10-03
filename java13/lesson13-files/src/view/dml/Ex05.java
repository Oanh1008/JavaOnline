package view.dml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import bean.Transaction;
import utils.FileUtils;

public class Ex05 {
	private static final String pathname = "storage" 
			+ File.separator + "data" 
			+ File.separator 
			+ "transaction.txt";
	private static final String output_path = 
			"storage" 
			+ File.separator + 
			"result" 
			+ File.separator 
			+ "output.txt";
	public static void main(String[] args) throws Exception {
		//b1: readfile
		Path path= Paths.get(pathname);
		//List<String>lines=Files.readAllLines(path);
		//1, Hennry, 1500, 03.04.2022
		//formatter dd.MM.yyyy
		List<Transaction>transactions=FileUtils.readlines(pathname, Transaction::new);
		transactions.forEach(System.out::println);
		//b2 process requirement
		//1 find Transactions with value condition (value >2000)
		List<Transaction>transactionsByValue=transactions.stream()
				    .filter(t->t.getValue()>2000)
				    .collect(Collectors.toList());
		
		
		//2 find Transactions with date condition(date >05.04.2022)
		List<Transaction>transactionsByDate=transactions.stream()
			    .filter(t->t.getDate().isAfter(LocalDate.of(2022, 04, 05)))
			    .collect(Collectors.toList());
		//b3 write out console, write back to output file
		
		// map 2 list
		List<Transaction>inputData= new ArrayList<>(transactionsByValue);
		inputData.addAll( transactionsByDate);
		System.out.println("=====================");
//		inputData.forEach(System.out::println);
		
		File file=FileUtils.createNewFile(output_path);
		if(file!=null) {
			FileUtils.writeLines(output_path, inputData);
		}
		
		
	}
}
