package view.Apple;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;
import functional.ApplePredicate;
import functional.GreenApplePredicate;
import functional.HeavyWeightApplePredicate;
import functional.LightWeightApplePredicate2;
import functional.RedApplePredicate;
import functional.WeightAndColorApplePredicate;
import model.DataModel;
import utils.Printable;

public class Ex04 {
	public static void main(String[] args) {
		List<Apple>inventory= DataModel.getApples();
		
		// 1st : find all green apples in his inventory
		List<Apple>greenApples= findApples(inventory,new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return "green".equals(apple.getColor());
			}
		});
		System.out.println("// 1st : find all green apples in his inventory");
		Printable.printElement(greenApples);
		System.out.println("==============================");
		
		// 2nd: find all red apples in his inventory
		List<Apple>redApples=findApples(inventory,new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return "red".equals(apple.getColor());
			}
		});
		System.out.println("// 2nd: find all red apples in his inventory");
		Printable.printElement(redApples);
		System.out.println("==============================");
		
		// 3rd: find all apples heavier than 150 g
		List<Apple>apple200= findApples(inventory,new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return apple.getWeight()>150;
			}
		});
		System.out.println("//// 3rd: find all apples heavier than 150 g");
		Printable.printElement(apple200);
		System.out.println("==============================");
		
		// 4th: find all apples lighter than 200g
		List<Apple>apple150= findApples(inventory,new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return apple.getWeight()<200;
			}
		});
		System.out.println("// 4th: find all apples lighter than 200g");
		Printable.printElement(apple150);
		System.out.println("==============================");
		
		// 5th: find all apples that are green and heavier than 400 g
		List<Apple>appleG400=findApples(inventory,new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return apple.getWeight()>400 && apple.getColor().equals("red");
			}}
			);
		System.out.println("//// 5th: find all apples that are green and heavier than 400 g");
		Printable.printElement(appleG400);
		System.out.println("==============================");
	}
	/*
	 * predicate could be 
	 * "green apples, heavy apples...
	 * three ways to pass apple predicate 
	 * 
	 * >> Pass requirement of Test method in ApplePredicate
	 * 1/ implementation class
	 * 
	 * 2/ anonymous class
	 * 			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return "Green".equals(apple.getColor());
	 * 3/ anonymous function
	 */
	private static List<Apple> findApples(List<Apple> inventory , ApplePredicate predicate){
		List<Apple> result= new ArrayList<>();
		for(Apple apple :inventory) {
			if(predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	
	
}
