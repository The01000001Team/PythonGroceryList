package main.java;

import java.awt.EventQueue;

import main.python.PyInterpreter;


public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/** Give the name of the .py file WITHOUT THE EXTENSION and it will launch the python file
	 * 
	 * @param fileName Name of the .py file
	 */
	public void launchPyFile(String fileName) {
		PyInterpreter.execPyFile(fileName);
	}
}
