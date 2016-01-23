package main.java;

import javax.swing.DefaultListModel;

public class ListManager {
	DefaultListModel recipeModel;
	
	public ListManager(){
		recipeModel = new DefaultListModel();
	}
	
	
	public DefaultListModel getListModel(){
		return recipeModel;
	}
}
