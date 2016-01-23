package main.java.UnitConversion.LiquidUnits;

import main.java.UnitConversion.Unit;

public class Cup extends Unit {

private final static String name = "cup";
	
	public Cup(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

}
