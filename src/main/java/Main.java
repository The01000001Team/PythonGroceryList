package main.java;

import java.awt.EventQueue;

import main.python.PyInterpreter;


public class Main {

	public static void main(String[] args) {

	}
	
	/** Give the name of the .py file WITHOUT THE EXTENSION and it will launch the python file
	 * 
	 * @param fileName Name of the .py file
	 */
	public void launchPyFile(String fileName) {
		PyInterpreter.execPyFile(fileName);
	}
}
