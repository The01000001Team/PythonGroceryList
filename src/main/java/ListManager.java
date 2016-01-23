package main.java;

import javax.swing.DefaultListModel;

import main.python.PyInterpreter;

public class ListManager {
	private static DefaultListModel recipeModel;
	
	public ListManager(){
		recipeModel = new DefaultListModel();
	}
	
	public void addUrl(String url){
		String[] recipe = PyInterpreter.execPyFile("Scrapper", url);
		if(recipe == null) {
			throw new NullPointerException();
		}
		
		/***
		 * This method should now take the string array and convert to item array
		 * This item array then needs to check if any item is ALREADY inside the listModel
		 * If so, adjust quantity/units accordingly
		 * If not, add to listModel (recipeModel.addElement(ITEM OBJECT));
		 * 
		 * the recipeModel is not typed, so you can add whatever type of objects you want and it will display
		 * their toString() method in the list. It would be best to ONLY add Item objects, however
		 */

		Item[] items = Item.toItemArray(recipe);
		
		for(int i=0; i<items.length; i++) {
			if(checkIfExistingItem(items[i])) {
				items[i] = null;
			}
			else recipeModel.addElement(items[i]);
		}

	}
	
	public DefaultListModel getListModel(){
		return recipeModel;
	}
	
	public static boolean checkIfExistingItem(Item item) {
		for(int i=0; i < recipeModel.getSize(); i++){
			Item existing = (Item) recipeModel.getElementAt(i);
			if(existing.getItemName().toLowerCase().equals(item.getItemName().toLowerCase())) {
				existing.updateCurrentItem(item);
				return true;
			}
		}
		return false;
	}
}
