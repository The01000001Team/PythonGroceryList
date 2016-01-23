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
	
}
