package main.java.UnitConversion;

public class TableSpoon extends Unit {

	private final static String name = "tbs";
	
	public TableSpoon(double quantity) {
		super(quantity, name);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public double convertToCup() {
		return (double) 1/16;
	}

}
