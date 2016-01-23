package main.java;

import javax.swing.DefaultListModel;
import javax.swing.JTextArea;

import main.python.PyInterpreter;

public class ListManager {
	DefaultListModel recipeModel;
	
	public ListManager(){
		recipeModel = new DefaultListModel();
	}
	
	public void addUrl(String url, JTextArea areaToBeCleared){
		String[] recipe = PyInterpreter.execPyFile("Scrapper", url);
		
		/***
		 * This method should now take the string array and convert to item array
		 * This item array then needs to check if any item is ALREADY inside the listModel
		 * If so, adjust quantity/units accordingly
		 * If not, add to listModel (recipeModel.addElement(ITEM OBJECT));
		 * 
		 * the recipeModel is not typed, so you can add whatever type of objects you want and it will display
		 * their toString() method in the list. It would be best to ONLY add Item objects, however
		 */
		areaToBeCleared.setText("");
	}
	
	public DefaultListModel getListModel(){
		return recipeModel;
	}
}
