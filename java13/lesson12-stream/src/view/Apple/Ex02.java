package view.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bean.Apple;
import model.DataModel;
import utils.Printable;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple>inventory= DataModel.getApples();
		
		// 1st : find all green apples in his inventory
		List<Apple>greenApples= findAllGreenApples(inventory);
		System.out.println("// 1st : find all green apples in his inventory");
		Printable.printElement(greenApples);
		System.out.println("==============================");
		
		// 2nd: find all red apples in his inventory
		List<Apple>redApples= findAllRedApples(inventory);
		System.out.println("// 2nd: find all red apples in his inventory");
		Printable.printElement(redApples);
		System.out.println("==============================");
		
		// 3rd: find all apples heavier than 150 g
		List<Apple>apple200= findHeavyApples(inventory);
		System.out.println("//// 3rd: find all apples heavier than 150 g");
		Printable.printElement(apple200);
		System.out.println("==============================");
		
		// 4th: find all apples lighter than 200g
		List<Apple>apple150= findLightApples(inventory);
		System.out.println("// 4th: find all apples lighter than 200g");
		Printable.printElement(apple150);
		System.out.println("==============================");
		
		// 5th: find all apples that are green and heavier than 400 g
		List<Apple>appleG400= findAppleByColorAndWeight(inventory);
		System.out.println("//// 5th: find all apples that are green and heavier than 400 g");
		Printable.printElement(appleG400);
		System.out.println("==============================");
	}
	// 1st : find all green apples in his inventory
	private static List<Apple> findAllGreenApples (List<Apple> inventory){
		List<Apple> result= new ArrayList<>();
		for(Apple i :inventory) {
			if("green".equals(i.getColor())) {
				result.add(i);
			}
		}
		return result;
	}
	// 2nd: find all red apples in his inventory
	private static List<Apple> findAllRedApples (List<Apple> inventory){
		List<Apple> result= new ArrayList<>();
		for(Apple i :inventory) {
			if("red".equals(i.getColor())) {
				result.add(i);
			}
		}
		return result;
	}
	// 3rd: find all apples heavier than 150 g
	private static List<Apple> findHeavyApples (List<Apple> inventory){
		List<Apple> result= new ArrayList<>();
		for(Apple i :inventory) {
			if(i.getWeight()>=150) {
				result.add(i);
			}
		}
		return result;
	}
	// 4th: find all apples lighter than 200g
	private static List<Apple> findLightApples (List<Apple> inventory){
		List<Apple> result= new ArrayList<>();
		for(Apple i :inventory) {
			if(i.getWeight()<200) {
				result.add(i);
			}
		}
		return result;
	}
	// 5th: find all apples that are green and heavier than 400 g
	private static List<Apple> findAppleByColorAndWeight (List<Apple> inventory){
		List<Apple> result= new ArrayList<>();
		for(Apple i :inventory) {
			if("green".equals(i.getColor()) && i.getWeight()>400) {
				result.add(i);
			}
		}
		return result;
	}
}
