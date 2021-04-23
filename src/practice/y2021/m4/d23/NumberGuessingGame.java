package practice.y2021.m4.d23;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class NumberGuessingGame {

	private static boolean nogui;
	private static Scanner inputScanner;
	
	public static void main(String[] args) {
		
		nogui = args.length > 0 && args[0].equals("nogui") ? true : false;
		
		int WOWSUPERSECRETGUESSEDNUMBERWOW = (int)(Math.random()*100+1);
		
		while(!guessGame(WOWSUPERSECRETGUESSEDNUMBERWOW)) {
			displayMsg("Please enter number",nogui);
		}
		
		if(inputScanner != null) {
			inputScanner.close();
			inputScanner = null;
		}
		displayMsg("You got it!",nogui);
	}

	public static boolean guessGame(int secretNumber){
		
		try {
			int guess = Integer.parseInt(getInput("Guess a number", nogui));
			while(guess != secretNumber) {
				if(guess > secretNumber) {
					guess = Integer.parseInt(getInput("Guess a lesser number", nogui));
				}else {
					guess = Integer.parseInt(getInput("Guess a greater number", nogui));
				}
			}
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void displayMsg(String m, boolean nogui) {
		if(nogui) {
			System.out.println(m);
		}
		else {
			JOptionPane.showMessageDialog(null, m, "Number guessing game", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static String getInput(String m, boolean nogui) {
		if(nogui) {
			if(inputScanner == null) inputScanner = new Scanner(System.in);
			return inputScanner.nextLine();
		}
		return JOptionPane.showInputDialog(m);
	}

}
