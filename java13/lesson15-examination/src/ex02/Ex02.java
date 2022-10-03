package ex02;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ex02 {
	private static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.print("Nhập tuổi của bạn: ");
		int age= Integer.parseInt(sc.nextLine());
		LocalTime timeToNeedSleep=getTimeToNeedSleep(age, getStandardSleepTime());
		System.out.println("Thời gian tối thiếu cần ngủ là: "
				+timeToNeedSleep.getHour()+ " giờ "
				+((timeToNeedSleep.getMinute()>0)?""+timeToNeedSleep.getMinute()+ " phút":""));
		System.out.println("=======================");
		LocalTime sleptTime=enterSleptTime();
		LocalTime startTime=enterStartSleepTime();
		
		LocalTime wakeUptime=getWakeUpTime(age,sleptTime, startTime);
		System.out.println("==================================");
		
		System.out.println(wakeUptime.getHour()+" giờ , "+wakeUptime.getMinute()+" phút");
	}
	
	private static LocalTime getWakeUpTime(int age,LocalTime sleptTime,LocalTime startTime) {
		LocalTime timeToNeedSleep = getTimeToNeedSleep(age, getStandardSleepTime());
		Duration remainTimeSleep= Duration.between(sleptTime, timeToNeedSleep);
		
		System.out.println(remainTimeSleep);
		System.out.println(remainTimeSleep.toMinutes());
		return startTime.plusMinutes(remainTimeSleep.toMinutes());
		
		// wakeUptime= startTime+ (timeToNeedSleep-SleptTime)
	}
	private static LocalTime getTimeToNeedSleep(int age,Map<AgeRange, LocalTime> standardSleepTimes) {
		for(Entry<AgeRange, LocalTime> standardSleepTime: standardSleepTimes.entrySet()) {
			if(standardSleepTime.getKey().contains(age)) {
				
				return standardSleepTime.getValue();
			}
			
		}
		return null;
		
	}
	private static Map<AgeRange, LocalTime> getStandardSleepTime(){
		return  new HashMap<AgeRange, LocalTime>(){
		
			private static final long serialVersionUID = 1L;

			{
				put(AgeRange.of(1, 3) , LocalTime.of(20, 0));
				put(AgeRange.of(4,13), LocalTime.of(11, 0));
				put(AgeRange.of(14, 17) , LocalTime.of(9, 0));
				put(AgeRange.of(18,64), LocalTime.of(8, 0));
				put(AgeRange.of(65) , LocalTime.of(7, 30));
				
			
			}
		};
	}
	private static LocalTime enterSleptTime() {
		System.out.println("Thời gian đã ngủ ");
		System.out.print("  + Số giờ: ");
		int sleptHours = Integer.parseInt(sc.nextLine());
		System.out.print("  + Số phút: ");
		int sleptMinutes = Integer.parseInt(sc.nextLine());
		return LocalTime.of(sleptHours, sleptMinutes);
	}
	
	private static LocalTime enterStartSleepTime() {
		System.out.println("Thời gian bắt đầu ngủ");
		System.out.print("  + Số giờ: ");
		int startHours = Integer.parseInt(sc.nextLine());
		System.out.print("  + Số phút: ");
		int startMinutes = Integer.parseInt(sc.nextLine());
		return LocalTime.of(startHours, startMinutes);
	}
}
