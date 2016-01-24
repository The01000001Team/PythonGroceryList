package main.java;

import java.awt.EventQueue;


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