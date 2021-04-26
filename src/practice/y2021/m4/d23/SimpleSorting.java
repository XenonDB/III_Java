package practice.y2021.m4.d23;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SimpleSorting {

	public static void main(String[] args) {
		
		System.out.println("簡易排序。欲排序的數值透過引數傳入。");
		
		if(args.length == 0) {
			System.out.println("無輸入參數，終止程式。");
			return;
		}
		
		ArrayList<BigDecimal> inputArray = new ArrayList<>(args.length);
		
		try {
			for(int i = 0; i < args.length ; i++) {
				inputArray.add(new BigDecimal(args[i]));
			}
		}
		catch(NumberFormatException e) {
			System.out.println("輸入中包含非數字參數，終止程式。");
			return;
		}
		
		StringBuilder msg = new StringBuilder("輸入順序:");
		for(Comparable<?> i : inputArray) {
			msg.append(" ");
			msg.append(i);
		}
		System.out.println(msg.toString());
		
		if(args.length > 10) {
			doQuickSort(inputArray);
		}
		else {
			doBubbleSort(inputArray);
		}
		
		msg = new StringBuilder("由大排到小:");
		for(int i = inputArray.size() - 1 ; i >= 0 ; i--) {
			msg.append(" ");
			msg.append(inputArray.get(i));
		}
		System.out.println(msg.toString());
		
		msg = new StringBuilder("由小排到大:");
		for(int i = 0 ; i < inputArray.size() ; i++) {
			msg.append(" ");
			msg.append(inputArray.get(i));
		}
		System.out.println(msg.toString());
		
	}
	
	/**由小排到大的quick sort*/
	public static void doQuickSort(ArrayList<BigDecimal> input) {
		System.out.println("執行快速排序");
		doQuickSort(input, 0, input.size() - 1);
	}

	private static void doQuickSort(ArrayList<BigDecimal> input, int start, int end) {
		
		int size = end - start + 1;
		
		if(size > 10) {
			
			//隨機選擇一個數字做基準，將陣列分為比該數字還小和比該數字還大的兩部分。
			swapElement(input, (int)(Math.random()*size) + start, end);
			BigDecimal compared = input.get(end);
			
			int cursorLeft = start;
			int cursorRight = end - 1;
			boolean flag;
			while(cursorLeft <= cursorRight) {
				flag = false;
				if(input.get(cursorRight).compareTo(compared) >= 0) {
					cursorRight--;
					flag = true;
				}
				if(input.get(cursorLeft).compareTo(compared) <= 0) {
					cursorLeft++;
					flag = true;
				}
				if(flag) continue;
				
				swapElement(input, cursorLeft, cursorRight);
				cursorRight--;
				cursorLeft++;
				
			}
			
			//沒有任何數字比基準還大的時候就不交換
			if(cursorLeft == cursorRight && cursorLeft + 1 == end) {
				doQuickSort(input, start, cursorLeft);
			}
			else {
				swapElement(input, cursorLeft, end);
				doQuickSort(input, start, cursorLeft-1);
				doQuickSort(input, cursorLeft + 1, end);
			}
			
		}
		else {
			doBubbleSort(input, start, end);
		}
	}
	
	private static void swapElement(ArrayList<BigDecimal> input, int i1, int i2) {
		BigDecimal i2ele = input.get(i2);
		input.set(i2, input.get(i1));
		input.set(i1, i2ele);
	}
	
	/**由小排到大的bubbleSort*/
	public static void doBubbleSort(ArrayList<BigDecimal> input) {
		System.out.println("執行泡沫排序");
		doBubbleSort(input, 0, input.size() - 1);
	}
	
	private static void doBubbleSort(ArrayList<BigDecimal> input, int start, int end) {
		for(int i = start ; i <= end ; i++) {
			for(int j = i+1 ; j <= end ; j++) {
				if(input.get(i).compareTo(input.get(j)) > 0) swapElement(input, i, j);
			}
		}
	}
	
}

