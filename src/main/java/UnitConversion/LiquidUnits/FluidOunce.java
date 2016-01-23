package main.java.UnitConversion.LiquidUnits;

import main.java.UnitConversion.Unit;

public class FluidOunce extends Unit {

private final static String name = "fl oz";
	
	public FluidOunce(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public double convertToCup() {
		return (double) 8;
	}

}
