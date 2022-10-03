package ex02;

public class AgeRange {
	private Integer max;
	private Integer min;
	
	
	private AgeRange() {
		
	}
	public static AgeRange of(int min,int max) {
		return new AgeRange().min(min).max(max);
	}
	public static AgeRange of(int min) {
		return new AgeRange().min(min);
	}
	public AgeRange min(int min) {
		this.min=min;
		return this;
	}
	public AgeRange max(int max) {
		this.max=max;
		return this;
	}
	public  boolean contains(int age) {
		return (max==null && min >=age) || (min <=age && max >=age);
	}
	public Integer getMax() {
		return max;
	}


	public Integer getMin() {
		return min;
	}
	
}
