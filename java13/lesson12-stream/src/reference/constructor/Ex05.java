package reference.constructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import bean.Trader;

/**
 * file trader.txt id, name, city 1, Smith, New York 2, Alain, Tonga 3, Henry,
 * Milan 4, Terry, Newcastle 5, Kaka, Milan .................. line: String[]
 * elements = split(", ");
 * 
 */

public class Ex05 {
	public static void main(String[] args) {
		List<String> lines = readData("trader.txt");
		lines.forEach(System.out::println);
		
		
		// constructor reference
		List<Trader> traders = map(lines,Trader::transfer);
		traders.forEach(System.out::println);
		
		
		
		// Static method reference
		List<Trader> traders1 = map1(lines);
		traders1.forEach(System.out::println);
		

	}

	private static <R> List<R> map(List<String> lines, Function<String, R> function) {
		List<R> rs = new ArrayList<>();
		for (String line : lines) {

			rs.add(function.apply(line));
		}
		return rs;
	}
	private static  List<Trader> map1(List<String> lines) {
		List<Trader> rs = new ArrayList<>();
		for (String line : lines) {
			
			rs.add(Trader.transfer(line));
		}
		return rs;
	}

	private static List<String> readData(String path) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Path.of(path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines != null ? lines : Collections.emptyList();

	}

}
