package main.java.UnitConversion.SolidUnits;

import main.java.UnitConversion.Unit;

public class Ounce extends Unit {

private final static String name = "oz";
	
	public Ounce(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

}
