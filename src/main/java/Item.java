package main.java;

import java.util.ArrayList;

import org.python.core.PyException;

import main.java.UnitConversion.Unit;
import main.java.UnitConversion.UnitConverter;
import main.python.PyInterpreter;

public class Item {
	
	private Unit unit;
	private String displayName;
	private String itemName;
	private double price;
	
	public Item(String itemName, double quantity, String unit) {
		this.displayName = itemName;
		this.itemName = itemName;
		this.unit = UnitConverter.getUnitFromString(unit, quantity);
		this.price = 0.0;
	}
	
	public Item(String itemName, double quantity, String unit, double price) {
		this.displayName = itemName;
		this.itemName = itemName;
		this.unit = UnitConverter.getUnitFromString(unit, quantity);
		this.price = price;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public void updateDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public Unit getUnit() {
		return this.unit;
	}
	
	public void setQuantity(double amount){
		unit.setQuantity(amount);
		price = amount * price;
	}
	
	public void updateCurrentItem(Item item2) {
		UnitConverter.convertToExistingUnit(this.getUnit(), item2.getUnit());
	}
	
	public String toString() {
		if(this.unit.getQuantity() != 0.0) {
			return (new DoubleToFraction(unit.getQuantity()).toString() + " " + unit.getName() + " \t\t " + displayName + " \t\t ") + ((price == 0.0) ? "Price Unavailable" : ("$" + String.valueOf(price)));
		}
		else {
			return (displayName + " \t\t ") + ((price == 0.0) ? "Price Unavailable" : ("$" + String.valueOf(price)));
		}
	}

	public static Object[] toItemArray(String[] recipe) {
		ArrayList<Item> result = new ArrayList<Item>();
		
		for(int x = 1; x<recipe.length; x++) {
			if(recipe[x].substring(recipe[x].length() - 1).equals(":")){
				continue;
			}
			String[] arrayStr = recipe[x].split(" ");
			String itemName = "";
			String itemUnit = "";
			double itemQuantity = 0.0;
			for(int i=0; i<arrayStr.length; i++) {
				if(arrayStr[i].substring(0,1).equals("-")) {
					arrayStr[i] = arrayStr[i].substring(1);
				}
				if(i == 0) {
					if(isDouble(arrayStr[i])) {
						itemQuantity = Double.parseDouble(arrayStr[i]);
						System.out.println("Item Quantity: " + String.valueOf(itemQuantity));
						continue;
					}
					else {
						itemName = addArrToString(arrayStr);
						break;
					}
				}
				if(i == 1) {
					itemUnit = arrayStr[i];
					System.out.println("Unit Type: " + itemUnit);
					continue;
				}
				if(i == 2) {
					if(instanceOfUnitName(arrayStr[i].toLowerCase()) && isDouble(arrayStr[i-1])) {
						itemUnit = arrayStr[i];
						System.out.println("Unit Type: " + itemUnit);
						itemQuantity = Double.parseDouble(arrayStr[i-1]);
						System.out.println("Item Quantity: " + String.valueOf(itemQuantity));
						continue;
					}
					if(arrayStr[i].substring(arrayStr[i].length() - 1).equals(",")) {
						itemName = arrayStr[i].substring(0, arrayStr[i].length()-1);
						break;
					}
					itemName = arrayStr[i];
					continue;
				}
				if(arrayStr[i].substring(arrayStr[i].length() - 1).equals(",")) {
					itemName = itemName + " " + arrayStr[i].substring(0, arrayStr[i].length()-1);
					break;
				}
				itemName = itemName + " " + arrayStr[i];
				
			}
			try{
				double price = PyInterpreter.execGroceryScraper("GroceryScrapper", itemName);
				result.add(new Item(FoodDictionary.findFoodItemFromDictionary(itemName.toLowerCase()), itemQuantity, itemUnit, itemQuantity*price));
			}catch(PyException e){
				result.add(new Item(FoodDictionary.findFoodItemFromDictionary(itemName.toLowerCase()), itemQuantity, itemUnit, -1.00));
			}
		}
		
		return result.toArray();
	}
	
	private static boolean instanceOfUnitName(String unitName) {
		switch(unitName) {
		case "teaspoon": return true;
		case "teaspoons": return true;
		case "tablespoon": return true;
		case "tablespoons": return true;
		case "cups": return true;
		case "ounce": return true;
		case "ounces": return true;
		case "drops": return true;
		case "pound": return true;
		case "pounds": return true;
		case "gallon": return true;
		case "gallons": return true;
		case "fluid ounce": return true;
		case "fluid ounces": return true;
		case "fl. oz.": return true;
		case "fl. oz": return true;
		case "pint": return true;
		case "pints": return true;
		case "quart": return true;
		case "quarts": return true;
		case "sticks": return true;
		}
		return false;
	}

	private static String addArrToString(String[] arrayStr) {
		String result;
		if(arrayStr[0].substring(arrayStr[0].length() - 1).equals(",")) {
			result = arrayStr[0].substring(0, arrayStr[0].length()-1);
			return result;
		}
		else result = arrayStr[0];
		for(int i=1; i<arrayStr.length; i++) {
			if(arrayStr[i].substring(arrayStr[i].length() - 1).equals(",")) {
				result = result + " " + arrayStr[i].substring(0, arrayStr[i].length()-1);
				break;
			}
			result = result + " " + arrayStr[i];
		}
		return result;
	}

	private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

	public double getPrice() {
		return price;
	}
}
