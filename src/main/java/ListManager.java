package main.java;

import javax.swing.DefaultListModel;

import main.python.PyInterpreter;

import org.python.core.PyException;

public class ListManager {
	@SuppressWarnings("rawtypes")
	private static DefaultListModel recipeModel;

	@SuppressWarnings("rawtypes")
	public ListManager(){
		recipeModel = new DefaultListModel();
	}

	/**
	 * RETURNS A STATUS. 1 = bad url, 0 = all good
	 */
	@SuppressWarnings("unchecked")
	public int addUrl(String url){
		System.out.println(url);
		try{
			String[] recipe = PyInterpreter.execRecipeScraper("Scrapper", url);
			Object[] items = Item.toItemArray(recipe);

			for(int i=0; i<items.length; i++) {

				if(checkIfExistingItem((Item)items[i])) {
					continue;
				}else recipeModel.addElement(items[i]);
			}

			return 0;
		}catch(PyException e){
			System.out.println("Returning 1");
			return 1;
		}

	}

	@SuppressWarnings("rawtypes")
	public DefaultListModel getListModel(){
		return recipeModel;
	}

	public static boolean checkIfExistingItem(Item item) {
		for(int i=0; i < recipeModel.getSize(); i++){
			Item existing = (Item) recipeModel.getElementAt(i);
			if(existing.getItemName().toLowerCase().equals(item.getItemName().toLowerCase()) && (existing.getUnit().canConvert() || existing.getUnit().getName().equals("clove")) && (item.getUnit().canConvert() || item.getUnit().getName().equals("clove"))) {
				existing.updateCurrentItem(item);
				return true;
			}
		}
		return false;
	}
}
