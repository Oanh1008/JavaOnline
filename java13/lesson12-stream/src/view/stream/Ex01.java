package view.stream;

import java.util.List;

import bean.Apple;
import model.DataModel;

public class Ex01 {
	public static void main(String[] args) {
		List<Apple>data=DataModel.getApples();
		data.stream().forEach(System.out::println);
	}
}
