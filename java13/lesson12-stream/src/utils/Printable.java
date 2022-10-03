package utils;

import java.util.Collection;
import java.util.List;

public  class Printable {
	private Printable() {
		// TODO Auto-generated constructor stub
	}
	public static  <E> void printElement(Collection<E> elements) {
		for(E e:elements) {
			System.out.println(e);
		}
	}
}
