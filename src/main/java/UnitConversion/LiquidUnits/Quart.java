package main.java.UnitConversion.LiquidUnits;

import main.java.UnitConversion.Unit;

public class Quart extends Unit {

private final static String name = "qt";
	
	public Quart(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

}
