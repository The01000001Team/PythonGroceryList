package main.java.UnitConversion;

import main.java.UnitConversion.LiquidUnits.Cup;
import main.java.UnitConversion.LiquidUnits.Drops;
import main.java.UnitConversion.LiquidUnits.FluidOunce;
import main.java.UnitConversion.LiquidUnits.Gallon;
import main.java.UnitConversion.LiquidUnits.Pint;
import main.java.UnitConversion.LiquidUnits.Quart;
import main.java.UnitConversion.SolidUnits.Ounce;
import main.java.UnitConversion.SolidUnits.Pound;

public class UnitConverter {

	/** Gets the proper Unit given the unit as a string. (i.e. "tbsp" returns a TableSpoon object)
	 * 
	 * @param unitName
	 * @return Returns the proper Unit object that corresponds to the string
	 */
	public static Unit getUnitFromString(String unitName, double quantity) {
		unitName = updateUnitName(unitName.toLowerCase());
		
		Unit result = getCorrectUnitFromString(unitName, quantity);
		return result;
	}
	
	public static String updateUnitName(String unitName) {
		switch(unitName) {
		case "teaspoon": unitName = "tsp";
		break;
		case "teaspoons": unitName = "tsp";
		break;
		case "tablespoon": unitName = "tbsp";
		break;
		case "tablespoons": unitName = "tbsp";
		break;
		case "cups": unitName = "cup";
		break;
		case "ounce": unitName = "oz";
		break;
		case "ounces": unitName = "oz";
		break;
		case "drops": unitName = "drop";
		break;
		case "pound": unitName = "lb";
		break;
		case "pounds": unitName = "lb";
		break;
		case "gallon": unitName = "gal";
		break;
		case "gallons": unitName = "gal";
		break;
		case "fluid ounce": unitName = "fl oz";
		break;
		case "fluid ounces": unitName = "fl oz";
		break;
		case "fl. oz.": unitName = "fl oz";
		break;
		case "fl. oz": unitName = "fl oz";
		break;
		case "pint": unitName = "pt";
		break;
		case "pints": unitName = "pt";
		break;
		case "quart": unitName = "qt";
		break;
		case "quarts": unitName = "qt";
		break;
		case "sticks": unitName = "stick";
		break;
		}
		
		System.out.println("Converted Unit Name: " + unitName);
		return unitName;
	}
	
	public static Unit getCorrectUnitFromString(String unitName, double quantity) {
		Unit result = null;
		
		switch(unitName) {
		case "stick": result = new Stick(quantity);
		break;
		case "fl oz": result = new FluidOunce(quantity);
		break;
		case "pt": result = new Pint(quantity);
		break;
		case "qt": result = new Quart(quantity);
		break;
		case "cup": result = new Cup(quantity);
		break;
		case "drop": result = new Drops(quantity);
		break;
		case "gal": result = new Gallon(quantity);
		break;
		case "oz": result = new Ounce(quantity);
		break;
		case "lb": result = new Pound(quantity);
		break;
		case "tbsp": result = new TableSpoon(quantity);
		break;
		case "tsp": result = new TeaSpoon(quantity);
		break;
		}
		
		return result != null ? result : new Unit(quantity, unitName);
	}
	
}
