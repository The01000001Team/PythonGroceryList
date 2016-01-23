package main.java.UnitConversion.LiquidUnits;

import main.java.UnitConversion.Unit;

public class Drops extends Unit {

private final static String name = "drop";
	
	public Drops(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

}
