package view.stream;

import java.util.List;
import java.util.stream.Collectors;

import bean.Apple;
import model.DataModel;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple>inventory=DataModel.getApples();
		List<Integer>ids=inventory.stream() // stream<apple>
				 .filter(apple->apple.getWeight()>100) // stream <apple>
				 .map(apple->apple.getId())
				 .collect(Collectors.toList()) //List<Integer>
				 ;
		ids.forEach(System.out::println);
	}
	
}
