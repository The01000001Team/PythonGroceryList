package main.java.UnitConversion.LiquidUnits;

import main.java.UnitConversion.Unit;

public class Pint extends Unit {

private final static String name = "pt";
	
	public Pint(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public double convertToCup() {
		return (double) 0.5;
	}

}
