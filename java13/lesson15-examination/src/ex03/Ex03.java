package ex03;

public class Ex03 {
	public static void main(String[] args) {
		String s1= "JA  Va";
		String s2= "ja     va";
		
		System.out.println(isAnagram(s1, s2));
		
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		byte[] s1_byte=s1.getBytes();
		byte[] s2_byte=s2.getBytes();
		System.out.println(sumOfByteElements(s2_byte)==sumOfByteElements(s1_byte));
	}
	private static int containsInString(Character  c,String s) {
		
		int count=0;
		for(int  i=0;i<s.length();i++) {
			if(c.equals(s.charAt(i))){
				count++;
			}
		}
		return count;
	}
	private static boolean isAnagram(String s1,String s2) {
		s1=s1.toLowerCase().trim().replaceAll("\\s+", "");
		s2=s2.toLowerCase().trim().replaceAll("\\s+", "");
		for(int i=0;i<s1.length();i++) {
			Character c= s1.charAt(i);
			if(containsInString(c, s1)!=containsInString(c, s2)) {
				return false;
			}
		}
		return true;
	}
	private static int sumOfByteElements(byte[] bytess) {
		
		int sum=0;
		for(byte bytes:bytess) {
			sum+=bytes;
		}
		return sum;
	}
}
