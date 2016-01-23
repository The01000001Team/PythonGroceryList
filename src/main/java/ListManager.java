package main.java;

import javax.swing.DefaultListModel;
import javax.swing.JTextArea;

import org.omg.CORBA.SystemException;
import org.python.core.PyException;

import main.python.PyInterpreter;

public class ListManager {
	private static DefaultListModel recipeModel;

	public ListManager(){
		recipeModel = new DefaultListModel();
	}

	/**
	 * RETURNS A STATUS. 1 failed, 2 success
	 */
	public int addUrl(String url){
		try{
			String[] recipe = PyInterpreter.execPyFile("Scrapper", url);

			Item[] items = Item.toItemArray(recipe);

			for(int i=0; i<items.length; i++) {
				/*
			if(checkIfExistingItem(items[i])) {
				continue;
			}
			else recipeModel.addElement(items[i]);
				 */
				recipeModel.addElement(items[i]);
			}
			
			return 0;
		}catch(PyException e){
			return 1;
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
