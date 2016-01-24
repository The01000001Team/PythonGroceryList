package main.java.UnitConversion;

public class TeaSpoon extends Unit {

private final static String name = "tsp";
	
	public TeaSpoon(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public double convertToCup() {
		return (double) 1/48;
	}
}
