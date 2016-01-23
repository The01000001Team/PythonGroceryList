package main.java.UnitConversion;

import java.util.HashMap;

import main.java.UnitConversion.LiquidUnits.Gallon;

public class UnitConverter {

	/** Gets the proper Unit given the unit as a string. (i.e. "tbsp" returns a TableSpoon object)
	 * 
	 * @param unitName
	 * @return Returns the proper Unit object that corresponds to the string
	 */
	public static Unit getUnitFromString(String unitName, double quantity) {
		HashMap<String, Unit> unitMap = populateMap();
		unitName = unitName.toLowerCase();
		
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
		}
		
		return null;
	}
	
	public static HashMap<String, Unit> populateMap() {
		HashMap<String, Unit> map = new HashMap<String, Unit>();
		map.put("gal", new Gallon(0));
		
		return map;
	}
	
}
