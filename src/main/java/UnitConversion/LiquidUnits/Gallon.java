package main.java.UnitConversion.LiquidUnits;

import main.java.UnitConversion.Unit;

public class Gallon extends Unit {

private final static String name = "gal";
	
	public Gallon(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

}
