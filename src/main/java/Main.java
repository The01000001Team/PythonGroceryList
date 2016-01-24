package main.java;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;

import main.python.PyInterpreter;


public class Main {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListManager listManager = new ListManager();
					HomeFrame frame = new HomeFrame(listManager);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}