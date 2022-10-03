package com.generic;

public class Ex04 {
	public static void main(String[] args) {
		IList<String> students= new CustomList<>();
		students.add("Vu Le");
		students.add("Nam Hoang");
		students.add("Hai Van");
		students.add("Teo Le");
		students.add("Hong Hoang");
//		students.set(4, "s");
//		System.out.println(students.get(2));
//		students.remove(4);
//		System.out.println("size "+students.size());
//		students.show();
		
		
		// count number of elements contains "Le"
		int count=students.count(t->t.contains("Le"));
		System.out.println(count);
		int count1 = ListUtils.count(students, student-> student.contains("Le"));
		System.out.println(count1);
	}
}	
