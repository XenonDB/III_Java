package practice.y2021.m4.d29;

public class Main1 {

	public static void main(String[] args) {
		BankAccount acc = new BankAccount("Steve",1500);
		System.out.println(acc);
		
		acc.addMoney(4876300000L);
		System.out.println(acc);
	}
	
}
