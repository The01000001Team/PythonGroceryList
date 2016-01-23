package main.java;

import main.java.UnitConversion.Unit;
import main.java.UnitConversion.UnitConverter;

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
	
	public void updateCurrentItem(Item item2) {
		UnitConverter.convertToExistingUnit(this.getUnit(), item2.getUnit());
	}
	
	public String toString() {
		if(this.unit.getQuantity() != 0.0) {
			return (new DoubleToFraction(unit.getQuantity()).toString() + " " + unit.getName() + " -- " + displayName + " -- ") + ((price == 0.0) ? "Price Unavailable" : ("$" + String.valueOf(price)));
		}
		return (displayName + " -- " + price == null ? "Price Unavailable" : ("$" + price));
	}

	public static Item[] toItemArray(String[] recipe) {
		Item[] result = new Item[recipe.length-1];
		
		for(int x = 1; x<recipe.length; x++) {
			String[] srtArray = recipe[x].split(" ");
			String itemName = "";
			String itemUnit = "";
			double itemQuantity = 0.0;
			for(int i=0; i<srtArray.length; i++) {
				if(i == 0) {
					if(isDouble(srtArray[i])) {
						itemQuantity = Double.parseDouble(srtArray[i]);
						System.out.println("Item Quantity: " + String.valueOf(itemQuantity));
						continue;
					}
					else {
						itemName = addArrToString(srtArray);
						break;
					}
				}
				if(i == 1) {
					itemUnit = srtArray[i];
					System.out.println("Unit Type: " + itemUnit);
					continue;
				}
				if(i == 2) {
					itemName = srtArray[i];
					continue;
				}
				itemName = itemName + " " + srtArray[i];
				
			}
			System.out.println("Item Name: " + itemName);
			result[1] = new Item(itemName, itemQuantity, itemUnit);
		}
		
		return result;
	}
	
	private static String addArrToString(String[] srtArray) {
		String result = srtArray[0];
		for(int i=1; i<srtArray.length; i++) {
			result = result + " " + srtArray[i];
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
}
