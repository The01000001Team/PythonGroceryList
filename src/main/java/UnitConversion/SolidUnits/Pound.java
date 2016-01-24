package main.java.UnitConversion.SolidUnits;

import main.java.UnitConversion.Unit;

public class Pound extends Unit {

private final static String name = "tbsp";
	
	public Pound(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public double convertToCup() {
		return (double) 0.52159;
	}
	
	public boolean canConvert() {
		return true;
	}

}
