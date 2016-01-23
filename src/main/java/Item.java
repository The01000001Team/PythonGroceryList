package main.java;

import main.java.UnitConversion.Unit;
import main.java.UnitConversion.UnitConverter;

public class Item {
	
	private Unit unit;
	private String displayName;
	private String itemName;
	private double price;
	
	public Item(String itemName, double quantity, String unit) {
		this.displayName = itemName;
		this.itemName = itemName;
		this.unit = UnitConverter.getUnitFromString(unit, quantity);
		this.price = (Double) null;
	}
	
	public Item(String itemName, double quantity, String unit, double price) {
		this.displayName = itemName;
		this.itemName = itemName;
		this.unit = UnitConverter.getUnitFromString(unit, quantity);
		this.price = price;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public void updateDisplayName(String displayName) {
		this.displayName = displayName;
	}	
	
	public String toString() {
		return (new DoubleToFraction(unit.getQuantity()).toString() + " " + unit.getName() + " -- " + displayName + " -- "
				+ price == null ? "Price Unavailable" : ("$" + price));
	}
}
