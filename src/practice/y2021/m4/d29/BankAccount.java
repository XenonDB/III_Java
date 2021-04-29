package practice.y2021.m4.d29;

import java.math.BigInteger;

public class BankAccount extends AbatractAccount {

	private BigInteger money;
	
	public BankAccount(String owner, long money) {
		super(owner);
		this.setMoney(money);
	}
	
	public BankAccount(String owner) {
		this(owner,0);
	}

	public String getMoney() {
		return money.toString();
	}

	public boolean setMoney(long m) {
		money = new BigInteger(Long.toString(m));
		return true;
	}

	public boolean addMoney(long m) {
		money = money.add(BigInteger.valueOf(m));
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Account owner: %s, money: %s, id: %d", getOwner(), getMoney(), getId());
	}
	
}
