package practice.y2021.m4.d23;

import java.util.Arrays;

public class SimpleSorting {

	public static void main(String[] args) {
		
		//System.out.println("簡易排序");
		
		if(args.length == 0) {
			System.out.println("無輸入參數，終止程式。");
			return;
		}
		
		int[] inputArray;
		
		try {
			inputArray = new int[args.length];
			for(int i = 0; i < inputArray.length ; i++) {
				inputArray[i] = Integer.valueOf(args[i]);
			}
		}
		catch(NumberFormatException e) {
			System.out.println("輸入中包含非數字參數，終止程式。");
			return;
		}
		
		StringBuilder msg = new StringBuilder("輸入順序:");
		for(int i : inputArray) {
			msg.append(" ");
			msg.append(i);
		}
		System.out.println(msg.toString());
		
		Arrays.parallelSort(inputArray);
		
		msg = new StringBuilder("由大排到小:");
		for(int i = inputArray.length - 1 ; i >= 0 ; i--) {
			msg.append(" ");
			msg.append(inputArray[i]);
		}
		System.out.println(msg.toString());
		
		msg = new StringBuilder("由小排到大:");
		for(int i = 0 ; i < inputArray.length ; i++) {
			msg.append(" ");
			msg.append(inputArray[i]);
		}
		System.out.println(msg.toString());
		
	}

		
}

