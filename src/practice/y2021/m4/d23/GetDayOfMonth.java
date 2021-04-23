package practice.y2021.m4.d23;

import java.util.Scanner;

public class GetDayOfMonth {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int y = s.nextInt();
		
		try {
			System.out.println(getDaysOfMonth(m,y));
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		s.close();
	}

	public static int getDaysOfMonth(int m, int year) throws IllegalArgumentException {
		if(m < 1 || m > 12) throw new IllegalArgumentException("非法月份");
		if(year < 1) throw new IllegalArgumentException("非法年份");
		
		if(m == 2) {
			if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) return 29;
			return 28;
		}
		
		return (30 + m%2 + (m < 8 ? 0 : 1));
	}
	
}
