package main.java.UnitConversion;

public class Stick extends Unit {

	private final static String name = "stick";
	
	public Stick(double quantity) {
		super(quantity, name);
	}
	
	public String getName() {
		return name;
	}
	
}
