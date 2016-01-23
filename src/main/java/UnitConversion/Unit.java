package main.java.UnitConversion;

public class Unit {

	private double quantity;
	private String unitName;
	
	public Unit(double quantity, String unitName) {
		this.quantity = quantity;
		this.unitName = unitName;
	}
	
	public String getName() {
		return this.unitName;
	}
	
	public double getQuantity() {
		return this.quantity;
	}
	
	public void increaseQuantity(double amount) {
		this.quantity = this.quantity + amount;
	}
	
	public void decreaseQuantity(double amount) {
		this.quantity = this.quantity + amount;
	}
	
	public double convertToCup() {
		return (double) 1;
	}
	
}
