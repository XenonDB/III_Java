package practice.y2021.m4.d29;

import java.util.Random;

public abstract class AbatractAccount {

	private static Random rng = new Random();
	
	private String owner;
	private long id;
	
	public AbatractAccount(String owner) {
		this.owner = owner;
		this.id = rng.nextLong();
	}
	
	public String getOwner() {
		return owner;
	}
	
	protected long getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return String.format("Account owner: %s, id: %d", getOwner(), getId());
	}
	
}
