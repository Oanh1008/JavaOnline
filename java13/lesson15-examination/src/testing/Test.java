package testing;

import java.util.Random;

public class Test {
	private static Random rd= new Random();
	public static void main(String[] args) {
		while(true) {
			int a= rd.nextInt(7)+1;
			int b= rd.nextInt(7)+1;
			int c= rd.nextInt(7)+1;
			System.out.println(a+""+b+""+c);
			
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
