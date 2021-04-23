package practice.y2021.m4.d23;

import java.util.Scanner;

public class PyramidePrinter {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int layer = s.nextInt();
		
		
		int spacecount;
		int lenghtcount;
		for(int i = 1; i <= layer ; i++) {
			spacecount = layer - i;
			lenghtcount = spacecount + i*2-1;
			for(int j = 0 ; j < lenghtcount ; j++) {
				if(spacecount > 0) {
					System.out.print(" ");
					spacecount--;
					continue;
				}
				System.out.print("*");
			}
			System.out.println();
		}
		s.close();
	}
}
