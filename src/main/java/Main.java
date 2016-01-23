package main.java;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;

import main.python.PyInterpreter;


public class Main {
	static DefaultListModel recipeModel = new DefaultListModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame(recipeModel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
/*
	 //Give the name of the .py file WITHOUT THE EXTENSION and it will launch the python file
	 // 
	 // @param fileName Name of the .py file
	 //
	public static void launchPyFile(String fileName) {
		PyInterpreter.execPyFile(fileName);
	}
*/
}